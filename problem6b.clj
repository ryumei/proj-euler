;; Project Euler Problem 6
;; http://projecteuler.net/index.php?section=problems&id=6
;; Last modified by NAKAJIMA Takaaki, Jul 2, 2010

; Solve!
(let [s (take 100 (iterate inc 1))      ; seq from 1 to 100
      xx (reduce + (for [i s] (* i i))) ; seq of the squares of the naturals
      y (reduce + s) ]                  ; sum of the naturals
  (- (* y y) xx))
