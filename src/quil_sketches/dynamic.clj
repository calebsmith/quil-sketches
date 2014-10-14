(ns quil-sketches.dynamic
  (:require [quil.core :refer :all]))


(def board-width 80)
(def board-height 80)


(defn board-get-index [x y]
    (+ (* y board-width) x))


(defn board-get-cell [board xin yin]
  (let [x (mod xin board-width)
        y (mod yin board-height)]
    (nth board (board-get-index x y))))


(defn draw-cell [board x y]
  (let [state (board-get-cell board x y)]
    (if (= state 1)
      (ellipse (* 10 x) (* 10 y) 4 4))))


(defn draw-board [board]
  (doall (map (fn [y]
    (doall (map (fn [x]
      (draw-cell board x y))
      (range board-width))))
    (range board-height))))


(defn draw [state]
  (background 255)
  (draw-board (:board state)))


(defn board-count-neighbor [board x y]
  (reduce + (map (fn [x-offset y-offset]
      (board-get-cell board (+ x x-offset) (+ y y-offset)))
    [-1 0 1 -1 1 -1 0 1]
    [-1 -1 -1 0 0 1 1 1])))


(defn board-next-cell [current neighbors]
    (if (= current 0)
        (if (= neighbors 3)
            1
            0)
        (if (or (= neighbors 2) (= neighbors 3))
            1
            0)))


(defn generate [board]
  (vec (flatten (map (fn [y]
    (doall (map (fn [x]
      (let [num-neighbors (board-count-neighbor board x y)
            current (board-get-cell board x y)]
        (board-next-cell current num-neighbors)))
      (range board-width))))
    (range board-height)))))


(defn update [state]
  (let [board (:board state)
        next-board (generate board)]
    {:board next-board}))
