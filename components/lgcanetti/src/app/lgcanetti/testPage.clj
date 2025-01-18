(ns app.lgcanetti.testpage)

(defn test-page 
  ([] (test-page "Default Message"))
  ([msg]
  [:div
   [:h1 "Test Page"]
   [:p (str "This is the function argument: " msg)]]))