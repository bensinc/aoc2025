(ns day1.core)
;; In aoc dir (with src sub dir) $ (require 'day1.core)
;; (require '[day1.core :as day1])
;; (in-ns 'day1.core)
;; (require 'day1.core :reload)

(defn rotate [start-position direction clicks]
  "Rotate the dial at position a number of clicks in a direction. +1 = right or -1 = left"
  (def position start-position)
  (doseq [i (range clicks)]
    (def position (+ position direction))
    (if (> position 99)
      (def position (- position 100))
     )
     (if (< position 0)
      (def position (+ 100 position))
     )
  )
  position
)

;;(rotate 0 1 5)

(defn day1 []
  "Day 1"
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
        (def position (rotate position 1 move))
        (def position (rotate position -1 move))
     )
     (print position)
     (print " -> ")
     
     (if (= position 0)
      (def code (+ code 1))
     )
     (println position)
    )
    (print "Code: ")
    (println code)
  )
)

(day1)