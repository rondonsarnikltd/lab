(ns yunior
  (:require [clojure.string :as str]))

(+ 9)

(str)

(def nombre "text")

nombre

(str/blank? nombre)

(str/blank? nil)

(str/blank? "")

(str/blank? "    ")

(+ 4 3)

(def data {:name "Juan"  :age 24 :sex :man :info {:address "Address" :phone "+1 301 9384983"} :state :havana})
(def provinces #{:havana :matanzas :pr})
(def set-data #{"a" "b" :b})
(def lista '("a" "a" :b :c 1))
(def arr [1 2 3 4 5 "string"])

(get data :name)
(get-in data [:info :phone])

(def info (:info data))
info
(name :havana)

(defn capitalize-first [s]
  (str (str/upper-case (subs s 0 1)) (subs s 1)))

(capitalize-first "havana")

(capitalize-first (name :havana))

info

(:address info)

(:name data)

(:name set-data)

;; set
(first set-data)
(second set-data)
(last set-data)

(nth set-data 2)

(def arreglo [:a :b "c" :d ["John" ["a" "b" "c"]]])

(nth arreglo 4)
(second (last arreglo))
