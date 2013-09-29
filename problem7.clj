;; Project Euler Problem 7
;; http://projecteuler.net/index.php?section=problems&id=7
;; Last modified by NAKAJIMA Takaaki, Sep 8, 2010

; is the prime number?
(defn prime?
  ([n]
   (every? false? (prime? n (- n 1))))
  ([n x]
   (lazy-seq
    (if (> x 1)
      (cons (zero? (rem n x)) (prime? n (dec x)))))))

; seq of the prime numbers
(defn prime-seq
  ([] (prime-seq 2))
  ([n]
   (lazy-seq
    (if (true? (prime? n))
      (cons n (prime-seq (inc n)))
      (prime-seq (inc n))))))

; Solve!
(first (reverse (take 10001 (prime-seq))))
