;; Project Euler Problem 9
;; http://projecteuler.net/index.php?section=problems&id=9
;; Last modified by NAKAJIMA Takaaki, Jul 7, 2010

; squared
(defn sqr [x] (* x x))

; pytagoren?
(defn pytagorean? [a b c]
  (= (sqr c) (+ (sqr a) (sqr b))))

; [cond] a < b < c, a + b + c = 1000
;   3a < a + b + c = 1000 < 3c
;   a <= 333, c > 333
(pytagorean? 3 4 5)

(defn divide-3-part
  ([n]
   (divide-3-part n (+ (quot n 3) 1)))
  ([n c]
   (let [ab (- n c)]
     (if (< c n)
       (if (> ab 2)
	 (divide-3-part n (dec c) c)))))
  ([n b c]
   (let [a (- n b c)]
     (if (and (> b a) (> a 0))
       (if (pytagorean? a b c)
	 (lazy-seq
	  (cons (seq [a b c]) (divide-3-part n (dec b) c)))
	 (divide-3-part n (dec b) c))
       (divide-3-part n (inc c))))))

; Solve!
(reduce * (first (divide-3-part 1000)))
