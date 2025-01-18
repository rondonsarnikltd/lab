(ns app.lgcanetti.testpage)

(defn test-page 
  ([] (test-page [:p (str "Default Message")]))
  ([arg]
  [:div
   [:h1 "Test Page"]
   arg]))