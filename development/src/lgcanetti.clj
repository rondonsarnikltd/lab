(ns lgcanetti)

(defn greet [name]
    (str "Hello, " name "!"))

(defn add [a b]
    (+ a b))

(defn subtract [a b]
    (- a b))

(defn multiply [a b]
    (* a b))

(defn divide [a b]
    (/ a b))

(defn user-message [keyword]
  (case keyword
    :simplicity "Simplicity is the ultimate sophistication."
    :complexity "Complexity is the enemy of execution."
    "Unknown keyword"))

(def x (user-message :simplicity))

println x