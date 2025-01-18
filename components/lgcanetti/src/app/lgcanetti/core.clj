(ns app.lgcanetti.core
  (:require [hiccup2.core :as h]
            [io.pedestal.http.params :as params] ;; we need this to access the path params in the requests
            [app.lgcanetti.index :as index]
            [app.lgcanetti.testpage :as testPage]))

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

(defn getHeaders []
  {"Content-Type" "text/html"
   "Content-Security-Policy" "img-src *"});Se cambio 'self' por *

(defn ok [body]
  {:status 200
   :headers (getHeaders)
   :body (-> body (h/html) (str))})

(defn respond [content]
  (ok (template (str (h/html (content))))))

(defn respond-with-params [content value]
  (ok (template (str (h/html (content value))))))

(def lgcanetti-page-handler
  {:name :get
   :enter (fn [context]
            (assoc context :response (respond index/content)))})

(defn processMsg [msg]
  (respond-with-params testPage/test-page [:p (str "The user has clicked on " msg)]))
 

(def message-handler
  {:name :get
   :enter (fn [context]
            (let [message (-> context :request :path-params :message)]
              ;; Respond with the value of message 
              (assoc context :response (processMsg message))))})

(def routes
  #{["/lgcanetti"
     :get lgcanetti-page-handler
     :route-name ::lgcanetti-page] 
    ["/lgcanetti/" 
     :get lgcanetti-page-handler 
     :route-name ::lgcanetti-prod]
    ["/lgcanetti/:message"
     :get [params/keyword-params message-handler]
     :route-name ::message-handler]})
