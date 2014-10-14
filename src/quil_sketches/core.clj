(ns quil-sketches.core
  (:require [quil-sketches.dynamic :as dynamic])
  (:require [quil.core :refer :all])
  (:require [quil.middleware :as m]))

; Start with Gosper Gun
(def base-states [
  [23 16]
  [24 16]
  [22 17]
  [21 18]
  [21 19]
  [21 20]
  [26 17]
  [27 18]
  [27 19]
  [27 20]
  [28 19]
  [25 19]
  [26 21]
  [22 21]
  [23 22]
  [24 22]
  [35 14]
  [35 15]
  [33 15]
  [32 16]
  [31 16]
  [32 17]
  [31 17]
  [32 18]
  [32 18]
  [33 19]
  [35 19]
  [35 20]
  [45 16]
  [46 16]
  [45 17]
  [46 17]
  [11 18]
  [12 18]
  [11 19]
  [12 19]
])


(defn base-states->initial-states [states]
  (vec (flatten (map (fn [[x y]]
      [(+ (* y dynamic/board-width) x) 1]
  ) states))))


(defn build-initial-board [states]
  (let [default-board (vec (repeat (* dynamic/board-width dynamic/board-height) 0))]
    (apply assoc (cons default-board (base-states->initial-states states)))))


(defn setup []
    (smooth)
    (background 255)
    (frame-rate 60)
    {:board (build-initial-board base-states)})


(defsketch qsketch
  :title "new stuff"
  :setup setup
  :draw dynamic/draw
  :update dynamic/update
  :middleware [m/fun-mode]
  :size [800 800])
