;; Project Euler Problem 6
;; http://projecteuler.net/index.php?section=problems&id=6
;; Last modified by NAKAJIMA Takaaki, Jul 2, 2010

;; [obsoleted]
(defn seq-of-the-squares-of-naturals [n]
  (let [n (int n)]
    (if (> n 0)
      (lazy-seq
       (cons (* n n) (seq-of-the-squares-of-naturals (dec n)))))))

;; [obsoleted]
(defn seq-of-the-sum-of-naturals [n]
  (let [n (int n)]
    (if (> n 0)
      (lazy-seq
       (cons n (seq-of-the-sum-of-naturals (dec n)))))))
;; [obsoleted]
;(let [n 100
;      x (reduce + (seq-of-the-squares-of-naturals n))
;      y (reduce + (seq-of-the-sum-of-naturals n)) ]
;  (- (* y y) x))

; Solve!
(let [s (take 100 (iterate inc 1))          ; 1 から
      x (reduce + (for [i s] (* i i)))
      y (reduce + s) ]
  (- (* y y) x))
