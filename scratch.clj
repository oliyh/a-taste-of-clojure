(ns )

(defn doubles [x]
  (* x 2))

(defn sequence-that [f]
  (map f (range 5)))

(sequence-that doubles)
;; => 0 2 4 6 8

(defn squares [x]
  (* x x))

(sequence-that (comp squares doubles))
;; => 0 4 16 36 64



(def numbers [0 1 2 3 4])

(map doubles numbers)
;; => 0 2 4 6 8

(map squares numbers)
;; => 0 1 4 9 16
