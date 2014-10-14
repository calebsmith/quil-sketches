(ns quil-sketches.core
  (:require [quil-sketches.dynamic :as dynamic])
  (:require [quil.core :refer :all])
  (:require [quil.middleware :as m]))

; Start with Gosper Gun
(def base-states [
  [13 6]
  [14 6]
  [12 7]
  [11 8]
  [11 9]
  [11 10]
  [16 7]
  [17 8]
  [17 9]
  [17 10]
  [18 9]
  [15 9]
  [16 11]
  [12 11]
  [13 12]
  [14 12]
  [25 4]
  [25 5]
  [23 5]
  [22 6]
  [21 6]
  [22 7]
  [21 7]
  [22 8]
  [21 8]
  [23 9]
  [25 9]
  [25 10]
  [35 6]
  [36 6]
  [35 7]
  [36 7]
  [1 8]
  [2 8]
  [1 9]
  [2 9]
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
