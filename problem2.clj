;;
;;  Project Euler Problem 2
;;  http://projecteuler.net/index.php?section=problems&id=2
;;  Last modified by NAKAJIMA Takaaki, Jun 28, 2010.
;;

;;
(defn fib [n]
  (if (= n 0) 0
      (if (= n 1)
	1
	(+ (fib (- n 1)) (fib (- n 2))))))

;;
(defn lazy-seq-fibo
  ([]
   (concat [0 1] (lazy-seq-fibo 0 1)))
  ([a b]
   (let [n (+ a b)]
     (lazy-seq
      (cons n (lazy-seq-fibo b n))))))

;;
(defn less-than-four-million? [n] (< n 4000000))

;;
;
(println (reduce +
		 (filter even?
			 (take-while less-than-four-million? (lazy-seq-fibo)))))
      
