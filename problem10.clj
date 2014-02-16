;; Project Euler Problem 10
;; http://projecteuler.net/index.php?section=problems&id=10
;; Last modified by NAKAJIMA Takaaki, Sep 8, 2010
;; Elapsed time: 40737.695 msecs (MBA 1.3GHz Intel Core i5)

; is the prime number?
(defn smart-prime? [n]
    (every? #(pos? (rem n %)) (range 2 (Math/sqrt (inc n)))))

; Solve!
;(time (reduce + (filter smart-prime? (range 2 (inc 10)))))
(time (reduce + (filter smart-prime? (range 2 (inc 2000000)))))
