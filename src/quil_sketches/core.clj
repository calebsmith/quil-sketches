(ns quil-sketches.core
  (:require [quil-sketches.dynamic :as dynamic])
  (:require [quil.core :refer :all])
  (:require [quil.middleware :as m]))

(defsketch gen-art-21
  :title "new stuff"
  :setup dynamic/setup
  :draw dynamic/draw
  :update dynamic/update
  :middleware [m/fun-mode]
  :size [800 800])
