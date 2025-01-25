(ns app.lgcanetti.index)

(def navclass {:selected-l "rounded-md bg-gray-900 px-3 py-2 text-sm font-medium text-white"
               :normal-l "rounded-md px-3 py-2 text-sm font-medium text-gray-300 hover:bg-gray-700 hover:text-white"
               :selected-p "block rounded-md bg-gray-900 px-3 py-2 text-base font-medium text-white"
               :normal-p "block rounded-md px-3 py-2 text-base font-medium text-gray-300 hover:bg-gray-700 hover:text-white"
               :mnu-l "block px-4 py-2 text-sm text-gray-700"
               :mnu-p "block rounded-md px-3 py-2 text-base font-medium text-gray-400 hover:bg-gray-700 hover:text-white"})

(def linktit ["Dashboard" "Team" "Projects" "Calendar" "Google" "Your Profile" "Settings" "Sign out"])

(defn content [dbcontent]
  [:div
   {:class "min-h-full"}
   [:nav
    {:class "bg-gray-800"}
    [:div
     {:class "mx-auto max-w-7xl px-4 sm:px-6 lg:px-8"}
     [:div
      {:class "flex h-16 items-center justify-between"}
      [:div
       {:class "flex items-center"}
       [:div
        {:class "shrink-0"}
        [:img
         {:class "w-8 h-8",
          :src
          "https://tailwindui.com/plus/img/logos/mark.svg?color=indigo&shade=500",
          :alt "Your Company"}]]
       [:div
        {:class "hidden md:block"}
        [:div
         {:class "ml-10 flex items-baseline space-x-4"}
         (comment
           "Current: \"bg-gray-900 text-white\", Default: \"text-gray-300 hover:bg-gray-700 hover:text-white\"")
         [:a
          {:href (if (:prod dbcontent) "/dashboard" "/lgcanetti/dashboard"),
           :class (if (= (:title dbcontent) (linktit 0)) (:selected-l navclass) (:normal-l navclass)),
           :aria-current "page"}
          (linktit 0)]
         [:a
          {:href (if (:prod dbcontent) "/team" "/lgcanetti/team"),
           :class (if (= (:title dbcontent) (linktit 1)) (:selected-l navclass) (:normal-l navclass))}
          (linktit 1)]
         [:a
          {:href (if (:prod dbcontent) "/projects" "/lgcanetti/projects"),
           :class (if (= (:title dbcontent) (linktit 2)) (:selected-l navclass) (:normal-l navclass))}
          (linktit 2)]
         [:a
          {:href (if (:prod dbcontent) "/calendar" "/lgcanetti/calendar"),
           :class (if (= (:title dbcontent) (linktit 3)) (:selected-l navclass) (:normal-l navclass))}
          (linktit 3)]
         [:a
          {:href "https://google.com",
           :target "_blank",
           :class (if (= (:title dbcontent) (linktit 4)) (:selected-l navclass) (:normal-l navclass))}
          (linktit 4)]]]]
      [:div
       {:class "hidden md:block"}
       [:div
        {:class "ml-4 flex items-center md:ml-6"}
        [:button
         {:type "button",
          :class
          "relative rounded-full bg-gray-800 p-1 text-gray-400 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800"}
         [:span {:class "absolute -inset-1.5"}]
         [:span {:class "sr-only"} "View notifications"]
         [:svg
          {:class "h-6 w-6",
           :fill "none",
           :viewBox "0 0 24 24",
           :stroke-width "1.5",
           :stroke "currentColor",
           :aria-hidden "true",
           :data-slot "icon"}
          [:path
           {:stroke-linecap "round",
            :stroke-linejoin "round",
            :d
            "M14.857 17.082a23.848 23.848 0 0 0 5.454-1.31A8.967 8.967 0 0 1 18 9.75V9A6 6 0 0 0 6 9v.75a8.967 8.967 0 0 1-2.312 6.022c1.733.64 3.56 1.085 5.455 1.31m5.714 0a24.255 24.255 0 0 1-5.714 0m5.714 0a3 3 0 1 1-5.714 0"}]]]
        (comment "Profile dropdown")
        [:div
         {:class "relative ml-3"}
         [:div
          [:button
           {:type "button",
            :class
            "relative flex max-w-xs items-center rounded-full bg-gray-800 text-sm focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800",
            :id "user-menu-button",
            :aria-expanded "false",
            :aria-haspopup "true",
            :onClick "toggleMenu()"
            :onBlur "toggleMenu(true)"}
           [:span {:class "absolute -inset-1.5"}]
           [:span {:class "sr-only"} "Open user menu"]
           [:img
            {:class "w-8 h-8 rounded-full",
             :src
             "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80",
             :alt "Photo"}]]]
         (comment
           "Dropdown menu, show/hide based on menu state.
         Entering: \"transition ease-out duration-100\"
         From: \"transform opacity-0 scale-95\"
         To: \"transform opacity-100 scale-100\"
         Leaving: \"transition ease-in duration-75\"
         From: \"transform opacity-100 scale-100\"
         To: \"transform opacity-0 scale-95\"")
         [:div
          {:class
           "absolute right-0 z-10 mt-2 w-48 origin-top-right rounded-md bg-white py-1 shadow-lg ring-1 ring-black/5 focus:outline-none hidden",
           :id "menu-tl",
           :role "menu",
           :aria-orientation "vertical",
           :aria-labelledby "user-menu-button",
           :tabindex "-1"}
          (comment
            "Active: \"bg-gray-100 outline-none\", Not Active: \"\"")
          [:a
           {:href (if (:prod dbcontent) "/profile" "/lgcanetti/profile"),
            :class (:mnu-l navclass),
            ;:onClick "toggleMenu()",
            :role "menuitem",
            :tabindex "-1",
            :id "user-menu-item-0"}
           (linktit 5)]
          [:a
           {:href (if (:prod dbcontent) "/settings" "/lgcanetti/settings"),
            :class (:mnu-l navclass),
            ;:onClick "toggleMenu()",
            :role "menuitem",
            :tabindex "-1",
            :id "user-menu-item-1"}
           (linktit 6)]
          [:a
           {:href (if (:prod dbcontent) "/sign-out" "/lgcanetti/sign-out"),
            :class (:mnu-l navclass),
            ;:onClick "toggleMenu()",
            :role "menuitem",
            :tabindex "-1",
            :id "user-menu-item-2"}
           (linktit 7)]]]]]
      [:div
       {:class "-mr-2 flex md:hidden"}
       (comment "Mobile menu button")
       [:button
        {:type "button",
         :class
         "relative inline-flex items-center justify-center rounded-md bg-gray-800 p-2 text-gray-400 hover:bg-gray-700 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800",
         :onClick "toggleMobileMenu()",
         :aria-controls "mobile-menu",
         :aria-expanded "false"}
        [:span {:class "absolute -inset-0.5"}]
        [:span {:class "sr-only"} "Open main menu"]
        (comment "Menu open: \"hidden\", Menu closed: \"block\"")
        [:svg
         {:class "block h-6 w-6"
          :id "svg-openmenu",
          :fill "none",
          :viewBox "0 0 24 24",
          :stroke-width "1.5",
          :stroke "currentColor",
          :aria-hidden "true",
          :data-slot "icon"}
         [:path
          {:stroke-linecap "round",
           :stroke-linejoin "round",
           :d "M3.75 6.75h16.5M3.75 12h16.5m-16.5 5.25h16.5"}]]
        (comment "Menu open: \"block\", Menu closed: \"hidden\"")
        [:svg
         {:class "hidden h-6 w-6",
          :id "svg-closemenu",
          :fill "none",
          :viewBox "0 0 24 24",
          :stroke-width "1.5",
          :stroke "currentColor",
          :aria-hidden "true",
          :data-slot "icon"}
         [:path
          {:stroke-linecap "round",
           :stroke-linejoin "round",
           :d "M6 18 18 6M6 6l12 12"}]]]]]]
    (comment "Mobile menu, show/hide based on menu state.")
    [:div
     {:class "md:hidden hidden", :id "mobile-menu"}
     [:div
      {:class "space-y-1 px-2 pb-3 pt-2 sm:px-3"}
      (comment
        "Current: \"bg-gray-900 text-white\", Default: \"text-gray-300 hover:bg-gray-700 hover:text-white\"")
      [:a
       {:href (if (get dbcontent :prod) "/dashboard" "/lgcanetti/dashboard"),
        :class (if (= (:title dbcontent) (linktit 0)) (:selected-p navclass) (:normal-p navclass)),
        :onClick "toggleMobileMenu()",
        :aria-current "page"}
       (linktit 0)]
      [:a
       {:href (if (:prod dbcontent) "/team" "/lgcanetti/team"),
        :onClick "toggleMobileMenu()",
        :class (if (= (:title dbcontent) (linktit 1)) (:selected-p navclass) (:normal-p navclass))}
       (linktit 1)]
      [:a
       {:href (if (:prod dbcontent) "/projects" "/lgcanetti/projects"),
        :onClick "toggleMobileMenu()",
        :class (if (= (:title dbcontent) (linktit 2)) (:selected-p navclass) (:normal-p navclass))}
       (linktit 2)]
      [:a
       {:href (if (:prod dbcontent) "/calendar" "/lgcanetti/calendar"),
        :onClick "toggleMobileMenu()",
        :class (if (= (:title dbcontent) (linktit 3)) (:selected-p navclass) (:normal-p navclass))}
       (linktit 3)]
      [:a
       {:href "https://google.com",
        :target "_blank",
        :onClick "toggleMobileMenu()",
        :class (if (= (:title dbcontent) (linktit 4)) (:selected-p navclass) (:normal-p navclass))}
       (linktit 4)]]
     [:div
      {:class "border-t border-gray-700 pb-3 pt-4"}
      [:div
       {:class "flex items-center px-5"}
       [:div
        {:class "shrink-0"}
        [:img
         {:class "w-12 h-12 rounded-full",
          :src
          "https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80",
          :alt "Photo"}]]
       [:div
        {:class "ml-3"}
        [:div {:class "text-base/5 font-medium text-white"} "Tom Cook"]
        [:div
         {:class "text-sm font-medium text-gray-400"}
         "tom@example.com"]]
       [:button
        {:type "button",
         :class
         "relative ml-auto shrink-0 rounded-full bg-gray-800 p-1 text-gray-400 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800"}
        [:span {:class "absolute -inset-1.5"}]
        [:span {:class "sr-only"} "View notifications"]
        [:svg
         {:class "h-6 w-6",
          :fill "none",
          :viewBox "0 0 24 24",
          :stroke-width "1.5",
          :stroke "currentColor",
          :aria-hidden "true",
          :data-slot "icon"}
         [:path
          {:stroke-linecap "round",
           :stroke-linejoin "round",
           :d
           "M14.857 17.082a23.848 23.848 0 0 0 5.454-1.31A8.967 8.967 0 0 1 18 9.75V9A6 6 0 0 0 6 9v.75a8.967 8.967 0 0 1-2.312 6.022c1.733.64 3.56 1.085 5.455 1.31m5.714 0a24.255 24.255 0 0 1-5.714 0m5.714 0a3 3 0 1 1-5.714 0"}]]]]
      [:div
       {:class "mt-3 space-y-1 px-2"}
       [:a
        {:href (if (:prod dbcontent) "/profile" "/lgcanetti/profile"),
         :onClick "toggleMobileMenu()",
         :class (:mnu-p navclass)}
        (linktit 5)]
       [:a
        {:href (if (:prod dbcontent) "/settings" "/lgcanetti/settings"),
         :onClick "toggleMobileMenu()",
         :class (:mnu-p navclass)}
        (linktit 6)]
       [:a
        {:href (if (:prod dbcontent) "/sign-out" "/lgcanetti/sign-out"),
         :class (:mnu-p navclass)}
        (linktit 7)]]]]]
   [:header
    {:class "bg-white shadow"}
    [:div
     {:class "mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8"}
     [:h1
      {:class "text-3xl font-bold tracking-tight text-gray-900"}
      (:title dbcontent)]]]
   [:main
    [:div
     {:class "mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8"}
     (comment "Your content")
     (:element dbcontent)]]] 
  )