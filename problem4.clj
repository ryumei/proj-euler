;; Project Euler Problem 4
;; http://projecteuler.net/index.php?section=problems&id=4
;; Last modified by NAKAJIMA Takaaki, Jul 2, 2010

; 逆転させる
(defn reverse-decimal 
  ([x] (reverse-decimal x 0))
  ([x y]
   (let [ x (int x)  y (int y) ] ; 整数で。
     (if (< x 1)
       y
       (reverse-decimal (quot x 10) (+ (* y 10) (rem x 10)))))))

; 回文数か？
(defn is-palindromic? [x]
  (let [x (int x)]
    (= (reverse-decimal x) x)))

; 遅延評価をしておかないと、StackOverflowError してしまう。
(defn recur_palindrome [ result p q pq_limit ]
  (lazy-seq
   (if (< p pq_limit)
     (let [prod (* p q)]
       (if (< q pq_limit)
	 (recur_palindrome (if (is-palindromic? prod)
			     (cons prod result) result) p (inc q) pq_limit)
	 (recur_palindrome (if (is-palindromic? prod)
			     (cons prod result) result) (inc p) p pq_limit)))
    result)))

; solve!
(first (sort > (recur_palindrome [] 100 100 1000)))
