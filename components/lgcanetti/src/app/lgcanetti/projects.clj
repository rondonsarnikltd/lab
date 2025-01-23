(ns app.lgcanetti.projects)

(def projects
  [{:name "Project 1" :description "Description for Project 1" :image "https://plus.unsplash.com/premium_photo-1736505438059-49c20fc32ff7?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwbHVzLWZlZWR8NTN8fHxlbnwwfHx8fHw%3D"}
   {:name "Project 2" :description "Description for Project 2" :image "https://plus.unsplash.com/premium_photo-1705169612592-32610774a5d0?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwbHVzLWZlZWR8MTh8fHxlbnwwfHx8fHw%3D"}
   {:name "Project 3" :description "Description for Project 3" :image "https://plus.unsplash.com/premium_photo-1732738372665-cefc61e5e4d2?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwbHVzLWZlZWR8NDd8fHxlbnwwfHx8fHw%3D"}])

(defn get-projects [projects]
  [:section
   {:class "relative isolate overflow-hidden bg-white px-6 py-24 sm:py-32 lg:px-8"}
   [:div
    {:class "absolute inset-0 -z-10 bg-[radial-gradient(45rem_50rem_at_top,theme(colors.indigo.100),white)] opacity-20"}]
   [:div
    {:class "mx-auto max-w-2xl lg:max-w-4xl"}
    (for [project projects]
      [:div
       {:class "mb-12"}
       [:img {:class "mx-auto h-32", :src (:image project), :alt (:name project)}]
       [:h2 {:class "text-center text-xl font-semibold text-gray-900"} (:name project)]
       [:p {:class "text-center text-gray-700"} (:description project)]])]])