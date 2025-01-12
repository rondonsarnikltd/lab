(ns app.lgcanetti.core
  (:require [hiccup2.core :as h]
            [app.lgcanetti.index :as index]))

; Prepare the hiccup to return it as html
(defn template [html-body]
  [:html
   {:class "h-full bg-gray-100"}
   [:head
    [:title "Luis G. Canetti Morales's Page"]
    [:link {:href "tailwind.min.css" :rel "stylesheet"}]
    [:script {:src "htmx.min.js"}]] 
   [:body 
    {:class "h-full"}
    (h/raw html-body)]])

(defn ok [body]
  {:status 200
   :headers {"Content-Type" "text/html" "Content-Security-Policy" "img-src 'self'"}
   :body (-> body
             (h/html)
             (str))})

(defn respond [content]
  (ok (template (str (h/html (content))))))

(def lgcanetti-page-handler
  {:name :get
   :enter (fn [context]
            (assoc context :response (respond index/content)))})

(def routes
  #{["/lgcanetti" :get lgcanetti-page-handler :route-name ::lgcanetti-page]})
