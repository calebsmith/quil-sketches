(ns hello-quil.core
  (:require [quil.core :refer :all])
  (:require [hello-quil.dynamic :as dynamic]))

(defsketch gen-art-21
  :title "Squared 2D Noise Grid"
  :setup dynamic/setup
  :draw dynamic/draw
  :size [600 600])
