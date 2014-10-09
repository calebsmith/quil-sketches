(ns hello-quil.core
  (:require [quil.core :refer :all])
  (:require [hello-quil.dynamic :as dynamic]))

(defsketch gen-art-21
  :title "Animated lines"
  :setup dynamic/setup
  :draw dynamic/draw
  :size [300 300])
