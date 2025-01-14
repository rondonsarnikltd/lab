(ns app.server.core
  (:require [com.stuartsierra.component :as component]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [io.pedestal.http.ring-middlewares :as middlewares]
            [jdbc-ring-session.core :as jdbc-ring-session]))

(defrecord ServerComponent [config datasource route]
  component/Lifecycle

  (start [component]
    (println "Starting server-component")
    (let [session-interceptor (when (some? datasource) (middlewares/session {:store (jdbc-ring-session/jdbc-store (datasource) {:table :session_store})}))
          config (-> {:env :prod
                      ::http/routes (route/expand-routes (:routes route))
                      ::http/resource-path "/public"
                      ::http/type :immutant
                      ::http/host "0.0.0.0"
                      ::http/port 8080}
                     (http/default-interceptors))
          with-session-interceptor (when (some? session-interceptor)
                                         (update config ::http/interceptors concat [session-interceptor]))
          server (if (some? with-session-interceptor)
                   (-> with-session-interceptor
                       (http/create-server)
                       (http/start))
                   (-> config
                       (http/create-server)
                       (http/start)))]
      
      (assoc component :server server)))

  (stop [component]
    (println "Stopping server-component")
    (when-let [server (:server component)]
      (http/stop server))
    (assoc component :server nil)))

(defn server-component
  [config]
  (map->ServerComponent {:config config}))