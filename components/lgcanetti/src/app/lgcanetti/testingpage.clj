(ns app.lgcanetti.testingpage)

(defn test-page 
  ([] (test-page [:p (str "Default Message")]))
  ([arg]
  [:div
   [:h1 "Testing Page"]
   arg]))