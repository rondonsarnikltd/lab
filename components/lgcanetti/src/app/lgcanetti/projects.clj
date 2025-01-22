(ns app.lgcanetti.projects)

(def projects
  [{:name "Project 1" :description "Description for Project 1" :image "https://example.com/Project1.jpg"}
   {:name "Project 2" :description "Description for Project 2" :image "https://example.com/project2.jpg"}
   {:name "Project 3" :description "Description for Project 3" :image "https://example.com/project3.jpg"}])

(defn get-projects [projects]
  [:section
   {:class "relative isolate overflow-hidden bg-white px-6 py-24 sm:py-32 lg:px-8"}
   [:div
    {:class "absolute inset-0 -z-10 bg-[radial-gradient(45rem_50rem_at_top,theme(colors.indigo.100),white)] opacity-20"}]
   [:div
    {:class "absolute inset-y-0 right-1/2 -z-10 mr-16 w-[200%] origin-bottom-left skew-x-[-30deg] bg-white shadow-xl shadow-indigo-600/10 ring-1 ring-indigo-50 sm:mr-28 lg:mr-0 xl:mr-16 xl:origin-center"}]
   [:div
    {:class "mx-auto max-w-2xl lg:max-w-4xl"}
    (for [project projects]
      [:div
       {:class "mb-12"}
       [:img {:class "mx-auto h-12", :src (:image project), :alt (:name project)}]
       [:h2 {:class "text-center text-xl font-semibold text-gray-900"} (:name project)]
       [:p {:class "text-center text-gray-700"} (:description project)]])]])