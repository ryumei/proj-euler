;;
;;  Project Euler Problem 1
;;  http://projecteuler.net/index.php?section=problems&id=1
;;  Last modified by NAKAJIMA Takaaki, Jan 29, 2010.
;;

(defn divisible? [n d] (== (mod n d) 0))
(defn divisible-by-3-or-5? [n] (or (divisible? n 3)
				   (divisible? n 5)))
(defn sum [n] (reduce + (filter divisible-by-3-or-5? (range n))))

(println (sum 1000))
