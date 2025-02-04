(ns app.lgcanetti.core
   (:require [hiccup2.core :as h]
             [io.pedestal.http.params :as params] ;; we need this to access the path params in the requests
             [clojure.string :as string]
             [app.lgcanetti.index :as index]
             [app.lgcanetti.login :as login]
             [app.lgcanetti.projects :as projects]
             [app.lgcanetti.team :as team]
             [app.lgcanetti.dashb :as dashb]
             [app.lgcanetti.newslett :as newslett]
             [app.lgcanetti.profile :as profile]))
 
(def envp true) ;; Change to true to use production environment

; Prepare the hiccup to return it as html
 (defn template [html-body]
   [:html
    {:class "h-full bg-gray-100"}
    [:head
     [:meta {:name "viewport" :content "width=device-width,initial-scale=1"}]
     [:title "Luis G. Canetti Morales's Page"]
     [:link {:href "tailwind.min.css" :rel "stylesheet"}]
     [:script {:src "htmx.min.js"}]
     [:script {:type "application/javascript" :src "lgcanetti.js"}]]
    [:body
     {:class "h-full"}
     (h/raw html-body)]])

 (defn getHeaders []
   {"Content-Type" "text/html"
    "Content-Security-Policy" "img-src *"});Changed: "img-src 'self'" by "img-src *"

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
             (let [params {:element (dashb/dashb-page) :title (index/linktit 0) :prod envp}]
             (assoc context :response (respond-with-params index/content params))))})
 
 (defn capitalize-first [s]
   (str (string/upper-case (subs s 0 1)) (subs s 1)))
 
 (defn getParams [item tit]
   {:element item :title tit :prod envp})

 (defn processMsg [msg]
   (println (str "Selected route: " msg))
   (cond 
     (= msg "sign-out") (respond-with-params login/login-page (getParams nil nil))
     (= msg "dashboard") (respond-with-params index/content (getParams (dashb/dashb-page) (index/linktit 0)))
     (= msg "projects") (respond-with-params index/content (getParams (projects/get-projects projects/projects) (index/linktit 2)))
     (= msg "team") (respond-with-params index/content (getParams (team/team-page) (index/linktit 1)))
     (= msg "newsletter") (respond-with-params index/content (getParams (newslett/newslett-page) (index/linktit 3)))
     (= msg "profile") (respond-with-params index/content (getParams (profile/profile-page) (index/linktit 5)))
     :else (let [item [:p (str "The user has clicked on " (capitalize-first msg))] tit (capitalize-first msg)] 
             (respond-with-params index/content (getParams item tit)))))


 (def message-handler
   {:name :get
    :enter (fn [context]
             (let [message (-> context :request :path-params :message)]
              ;; Respond with the value of message 
               (assoc context :response (processMsg message))))})
 
 (comment 
   (def lgcanetti-login-handler
   {:name :post
    :enter (fn [context]
             (let [params (-> context :request :form-params) args {:element [:p "User loged in!"] :prod envp}]
               (println (str "Login form submitted with params: " params))
               ;; Aquí puedes agregar la lógica para autenticar al usuario
               ;; Por ejemplo, verificar el nombre de usuario y la contraseña
               (assoc context :response (respond-with-params index/content args))))})
   )
 
 (defn lgcanetti-login-handler [context]
   (let [params (-> context :request :form-params) args {:element [:p "User loged in!"] :prod envp}]
     (println (str "Login form submitted with params: " params))
     ;; Aquí puedes agregar la lógica para autenticar al usuario
     ;; Por ejemplo, verificar el nombre de usuario y la contraseña
     (assoc context :response (respond-with-params index/content args))))

(def routes
  #{["/lgcanetti"
     :get lgcanetti-page-handler
     :route-name ::lgcanetti-page]
    ["/lgcanetti/"
     :get lgcanetti-page-handler
     :route-name ::lgcanetti-prod]
    ["/lgcanetti/login";TODO: ver con Yunior por que esta ruta no trabaja
     :post [params/keyword-params lgcanetti-login-handler]
     :route-name ::lgcanetti-login-handler]
    ["/lgcanetti/:message"
     :get [params/keyword-params message-handler]
     :route-name ::message-handler]})
