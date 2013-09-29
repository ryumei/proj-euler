;; Project Euler Problem 5
;; http://projecteuler.net/index.php?section=problems&id=5
;; Last modified by NAKAJIMA Takaaki, Jul 2, 2010

; x を n 以下の自然数で割り切れるか？
(defn defactorize-seq [x n]
  (let [x (int x) n (int n)]
    (if (> n 0)
      (if (= (rem x n) 0)
	(lazy-seq (cons n (defactorize-seq x (dec n))))))))

; solve!
(let [n 20]
  (loop [ x n ]
    (let [ d-seq (defactorize-seq x n)]
      (if (= (count d-seq) n) ; n! までたどり着けば必ず抜けられるはず。
	x
	(recur (+ x n))))))   ; ちょっと手抜き
