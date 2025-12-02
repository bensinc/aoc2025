(ns day1-2.core)
;; In aoc dir (with src sub dir) $ (require 'day1.core)
;; (require '[day1.core :as day1])
;; (in-ns 'day1.core)
;; (require 'day1.core :reload)

(defn rotate [start-position direction clicks]
  "Rotate the dial at position a number of clicks in a direction. +1 = right or -1 = left"
  (def position start-position)
  (def zeros 0)
  (doseq [i (range clicks)]
    (def position (+ position direction))    
    (if (> position 99)
      (def position (- position 100))
     )
     (if (< position 0)
      (def position (+ 100 position))
     )
     (if (= position 0)
       (def zeros (+ zeros 1))
     )
  )
  [position, zeros]
)

;;(rotate 0 1 5)

(defn day1-2 []
  "Day 1-2"
  (def position 50)
  (def code 0)
  (with-open [reader (clojure.java.io/reader "src/day1/input.txt")]
    (doseq [line (line-seq reader)]
      (def move (Integer/parseInt (apply str (rest (sequence line)))))
      (print "Position: ")
      (print position)
      (print " -> ")
      (print line)
      (print " = ")
      (if (= (first (sequence line)) \R)
        (do
          (def result (rotate position 1 move))
          (def position (first result))
          (def code (+ code (last result))))
        (do
          (def result (rotate position -1 move))
          (def position (first result))
          (def code (+ code (last result))))
     )
     (print position)
     (print " -> ")
     
     
     (println position)
    )
    (print "Code: ")
    (println code)
  )
)

(day1-2)