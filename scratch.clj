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

(defn fib
  ([] (fib 0 1))
  ([i j] (lazy-seq (cons i (fib j (+ i j))))))


(defschema Foo {:a [Int]
                :b Str})

(validate Foo {:a "not numbers"
               :b :not-a-string})

;; => ExceptionInfo Value does not match schema:
;;    {:a (not (sequential? "not numbers")),
;;     :b (not (instance? java.lang.String :not-a-string))}

(generate {:a Int :b Str})

[{:a []
  :b ""}

 {:a [-18]
  :b ""}

 {:a [876545 -9776]
  :b "-a90%bD!"}

 {:a [122176 0 8391213001]
  :b ".{7s_kdqW;iYf ywV39*"}

 {:a [9 65342 9879634211 -31 1434988905 411 -65681247 ... ]
  :b "      -  \OC6 daQ @'`sgeR ¬| f_bdA ... "}]
