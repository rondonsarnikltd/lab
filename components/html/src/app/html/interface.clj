(ns app.html.interface
  (:require [app.html.core :as core]))

(defn get-routes []
  core/routes)

(defn respond [content]
  (core/respond content))