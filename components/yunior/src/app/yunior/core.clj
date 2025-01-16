(ns app.yunior.core
  (:require [hiccup2.core :as h]
            [app.yunior.index :as index]))

;; Prepare the hicup to return it as html
(defn template [html-body]
  [:html
   [:head
    [:title "Title"]
    [:link {:href "../tailwind.min.css" :rel "stylesheet"}]
    [:script {:src "../htmx.min.js"}]]
   [:body (h/raw html-body)]])

(defn ok [body]
  {:status 200
   :headers {"Content-Type" "text/html" "Content-Security-Policy" "img-src 'self'"}
   :body (-> body
             (h/html)
             (str))})

(defn respond [content]
  (ok (template (str (h/html (content))))))

(def yunior-page-handler
  {:name :get
   :enter (fn [context]
            (assoc context :response (respond index/content)))})

(def routes
  #{["/yunior/" :get yunior-page-handler :route-name ::yunior-page]})
