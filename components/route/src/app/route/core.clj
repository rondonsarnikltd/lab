(ns app.route.core
  (:require [com.stuartsierra.component :as component]
            [app.html.interface :as html]
            [app.user.interface :as user]
            [app.yunior.interface :as yunior]
            [app.lgcanetti.interface :as lgcanetti]))

(defrecord RouteComponent [config]
  component/Lifecycle

  (start [component]
    (println "Starting route-component")
    (assoc component :routes (into #{} (concat 
                                        (user/get-routes) 
                                        (html/get-routes)
                                        (yunior/get-routes)
                                        (lgcanetti/get-routes)))))

  (stop [component]
    (println "Stopping server-component")
    (assoc component :routes nil)))

(defn route-component [config]
  (map->RouteComponent {:config config}))