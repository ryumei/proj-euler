;;
;; nakajima.clj : Project Euler 向けのライブラリィ
;; Last modified by NAKAJIMA Takaaki, Nov 19, 2010
;;
;; [to load]
;; (load-file "nakajima.clj")
;;

;; ---------------------------------------------------------------------

;; 律儀な素因数分解, see also Problem 3
(defn scrupulous-factor
  ([n]
   (scrupulous-factor n 2))
  ([n, d]
   (if (>= n d)
     (if (= (rem n d) 0)
       (cons d (scrupulous-factor (quot n d) d))
       (scrupulous-factor n (+ d 1))))))

;; 遅延化した素因数分解, see also Problem 3
(defn lazy-seq-factor
  ([n]
     (lazy-seq-factor n 2))
  ([n, d]
   (if (>= n d)
     (if (= (rem n d) 0)
       (lazy-seq
	(cons d (lazy-seq-factor (quot n d) d)))
       (lazy-seq-factor n (+ d 1))))))

;; 素因数分解 (as a wrapper)
(defn prime-factors [n]
  (lazy-seq-factor n))

;; ---------------------------------------------------------------------

;; 素数？
;; is the prime number?
(defn prime?
  ([n]
   (every? false? (prime? n (- n 1))))
  ([n x]
   (lazy-seq
    (if (> x 1)
      (cons (zero? (rem n x)) (prime? n (dec x)))))))

;; ---------------------------------------------------------------------

;; 三角数 (1 から n までの和)
;; triangle number
(defn triangle-number [n]
  (reduce + (range 1 (+ n 1))))

;; うっかり書いてしまった、reduce *
(defn reduce-multiply
  ([list]
     (reduce-multiply (first list) (rest list)))
  ([val, list]
     (if (= list ())
       val
       (reduce-multiply (* val (first list)) (rest list)))))


;; ---------------------------------------------------------------------

;; 二つの seq をつなげる
;;
;; user=> (append-seq '(1 2 3) '(4 5 6))
;; (1 2 3 4 5 6)
;; user=> (append-seq '((1 2) (3 4)) '((4 5) (5 6)))
;; ((1 2) (3 4) (4 5) (5 6))
;;
(defn append-seq [ p, q ]
  (lazy-seq
   (if (= p ())
     q
     (cons (first p) (append-seq (rest p) q)))))

;; ---------------------------------------------------------------------

;; list から 2 個選ぶ組み合わせ
;;
;; user=> (comb2 (range 1 6))
;; ((2 1) (3 1) (4 1) (5 1) (3 2) (4 2) (5 2) (4 3) (5 3) (5 4))
(defn comb2
  ([list]
     (comb2 (rest list) [ (first list) ]))
  ([parent, child]
     (lazy-seq
      (if (not (= parent ())) ;; count?
	(append-seq
	 (for [val parent] (cons val child))
	 (comb2 (rest parent) [ (first parent) ]))))))

;; list から, n 個選びとる組み合わせを返す。
					; 未完成
(defn comb-n
  ([parent, child]
     (lazy-seq
      (if (not (= parent ())) ;; count?
	(append-seq
	 (for [val parent] (cons val child))
	 (comb-n (rest parent) child))))))

;; EOF