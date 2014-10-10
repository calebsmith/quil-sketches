(ns quil-sketches.dynamic
  (:require [quil.core :refer :all]))

(def board-width 100)
(def board-height 100)

(defn setup []
  (smooth)
  (background 255)
  (frame-rate 60)
  {:board [0 1 1 0]})

(defn draw-cell [x y]
  (ellipse x y 5 5))


(defn draw-board []
  (map (fn [y] (println y)) (range board-height)))


(defn draw [state]
  (background 255)
  (draw-cell 10 10)
  (draw-board))


(defn update [state]
  state)
