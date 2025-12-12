(ns day2.core)
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

(defn day2 []
  "Day 2"
  (def total 0)
  (def file-content (clojure.string/replace (slurp "src/day2/input2.txt") #"\n" ""))
  (def parts (clojure.string/split file-content #","))
  (println parts)
)

(day2)