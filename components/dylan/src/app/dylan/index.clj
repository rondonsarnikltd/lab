(ns app.dylan.index)

(defn content []
  [:div
   {:class "bg-white"}
   [:header
    {:class "absolute inset-x-0 top-0 z-50"}
    [:nav
     {:class "flex items-center justify-between p-6 lg:px-8 lg:hidden",
      :aria-label "Global"}
     [:div
      {:class "flex lg:flex-1"}
      [:a
       {:href "#", :class "-m-1.5 p-1.5"}
       [:span {:class "sr-only"} "Your Company"]]]
     
     [:div
      {:class "hidden lg:flex lg:gap-x-12"}
      [:a
       {:href "#", :class "text-sm/6 font-semibold text-gray-900"}
       "Product"]
      [:a
       {:href "#", :class "text-sm/6 font-semibold text-gray-900"}
       "Features"]
      [:a
       {:href "#", :class "text-sm/6 font-semibold text-gray-900"}
       "Marketplace"]
      [:a
       {:href "#", :class "text-sm/6 font-semibold text-gray-900"}
       "Company"]]
     [:div
      {:class "hidden lg:flex lg:flex-1 lg:justify-end"}
      [:a
       {:href "#", :class "text-sm/6 font-semibold text-gray-900"}
       "Log in"
       [:span {:aria-hidden "true"} "→"]]]]
    (comment "Mobile menu, show/hide based on menu open state.")
    [:div
     {:class "lg:hidden", :role "dialog", :aria-modal "true"}
     (comment
       "Background backdrop, show/hide based on slide-over state.")
     [:div {:class "fixed inset-0 z-50"}]
     ]]
   [:div
    {:class "relative isolate px-6 pt-14 lg:px-8"}
    [:div
     {:class
      "absolute inset-x-0 -top-40 -z-10 transform-gpu overflow-hidden blur-3xl sm:-top-80",
      :aria-hidden "true"}
     [:div
      {:class
       "relative left-[calc(50%-11rem)] aspect-1155/678 w-[36.125rem] -translate-x-1/2 rotate-[30deg] bg-linear-to-tr from-[#ff80b5] to-[#9089fc] opacity-30 sm:left-[calc(50%-30rem)] sm:w-[72.1875rem]",
       :style
       "clip-path: polygon(74.1% 44.1%, 100% 61.6%, 97.5% 26.9%, 85.5% 0.1%, 80.7% 2%, 72.5% 32.5%, 60.2% 62.4%, 52.4% 68.1%, 47.5% 58.3%, 45.2% 34.5%, 27.5% 76.7%, 0.1% 64.9%, 17.9% 100%, 27.6% 76.8%, 76.1% 97.7%, 74.1% 44.1%)"}]]
    [:div
     {:class "mx-auto max-w-2xl py-32 sm:py-48 lg:py-56"}
     [:div
      {:class "hidden sm:mb-8 sm:flex sm:justify-center"}]
     [:div
      {:class "text-center"}
      [:h1
       {:class
        "text-5xl font-semibold tracking-tight text-balance text-gray-900 sm:text-7xl"}
       "Te amo mi amor"]
      [:p
       {:class
        "mt-8 text-lg font-medium text-pretty text-gray-500 sm:text-xl/8"}
       "Te dedico estas dos canciones."]
      [:div
       {:class "mt-10 flex items-center justify-center gap-x-6"}
       
       [:div
        {:class "flex items-center justify-center"}
        [:audio
         {:controls "", :class "w-64 rounded-lg shadow-lg"}
         (if (= (System/getenv "ENVIRONMENT") "prod")
           [:source {:src "song-1.mp3", :type "audio/mp3"}]
           [:source {:src "../song-1.mp3", :type "audio/mp3"}])
         "Your browser does not support the audio element."]]
       
       [:div
        {:class "flex items-center justify-center"}
        [:audio
         {:controls "", :class "w-64 rounded-lg shadow-lg"}
         (if (= (System/getenv "ENVIRONMENT") "prod")
           [:source {:src "song-2.mp3", :type "audio/mp3"}]
           [:source {:src "../song-2.mp3", :type "audio/mp3"}])
         "Your browser does not support the audio element."]]]]]
    [:div
     {:class
      "absolute inset-x-0 top-[calc(100%-13rem)] -z-10 transform-gpu overflow-hidden blur-3xl sm:top-[calc(100%-30rem)]",
      :aria-hidden "true"}
     [:div
      {:class
       "relative left-[calc(50%+3rem)] aspect-1155/678 w-[36.125rem] -translate-x-1/2 bg-linear-to-tr from-[#ff80b5] to-[#9089fc] opacity-30 sm:left-[calc(50%+36rem)] sm:w-[72.1875rem]",
       :style
       "clip-path: polygon(74.1% 44.1%, 100% 61.6%, 97.5% 26.9%, 85.5% 0.1%, 80.7% 2%, 72.5% 32.5%, 60.2% 62.4%, 52.4% 68.1%, 47.5% 58.3%, 45.2% 34.5%, 27.5% 76.7%, 0.1% 64.9%, 17.9% 100%, 27.6% 76.8%, 76.1% 97.7%, 74.1% 44.1%)"}]]]])