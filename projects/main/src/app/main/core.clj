(ns app.main.core
  (:require [com.stuartsierra.component :as component]
            [app.storage.interface :as storage]
            [app.route.interface :as route]
            [app.server.core :as server]))

(def config {:with-db false
             :db-spec {:dbtype "postgres"
                       :host (if (= (System/getenv "ENVIRONMENT") "prod") (System/getenv "DB_HOST") "localhost")
                       :dbname (System/getenv "DB_NAME")
                       :username "user"
                       :password (if (= (System/getenv "ENVIRONMENT") "prod") (System/getenv "DB_PASSWORD") "password@2025")
                       :dataSourceProperties {:socketTimeout 30}}})

(defn create-system [config]
  (if (:with-db config)
    (component/system-map 
     :datasource (storage/datasource-component config)
     :route (route/route-component config)
     :server (component/using
              (server/server-component config)
              [:route :datasource]))
    (component/system-map
     :route (route/route-component config)
     :server (component/using
              (server/server-component config)
              [:route]))))

(defn -main []
  (let [system (-> config
                   (create-system)
                   (component/start-system))]
    (println "Starting system for project: main with config")
    (.addShutdownHook
     (Runtime/getRuntime)
     (new Thread #(component/stop-system system)))))