(ns hello-quil.dynamic
  (:require [quil.core :refer :all]
            [quil.helpers.seqs :refer [range-incl]]
            [quil.helpers.calc :refer [mul-add]]))

(defn draw-point
  [x y noise-factor]
  (let [len (* 10 noise-factor)]
    (ellipse x y len len)))

(defn draw-squares
  [x-start y-start]
  (dorun
   (for [y (range-incl 0 (height) 5)
         x (range-incl 0 (width) 5)]
     (let [x-noise (mul-add x 0.01 x-start)
           y-noise (mul-add y 0.02 y-start)
           alph    (* 255 (noise x-noise y-noise))]
       (draw-point x y (noise x-noise y-noise))))))

(defn setup []
  (smooth)
  (frame-rate 5)
  (background 255))

(defn draw []
  (draw-squares (random 8) (random 10)))
