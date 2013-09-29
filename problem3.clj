;; Project Euler Problem 3
;; http://projecteuler.net/index.php?section=problems&id=3
;; Last modified by NAKAJIMA Takaaki, Jul 2, 2010

;; 律儀な因数分解
(defn scrupulous-factor
  ([n]
   (scrupulous-factor n 2))
  ([n, d]
   (if (>= n d)
     (if (= (rem n d) 0)
       (cons d (scrupulous-factor (quot n d) d))
       (scrupulous-factor n (+ d 1))))))

;; 遅延化した因数分解
(defn lazy-seq-factor
  ([n]
   (lazy-seq-factor n 2))
  ([n, d]
   (if (>= n d)
     (if (= (rem n d) 0)
       (lazy-seq
	(cons d (lazy-seq-factor (quot n d) d)))
       (lazy-seq-factor n (+ d 1))))))

;; solve!
(first (sort > (lazy-seq-factor 600851475143)))

