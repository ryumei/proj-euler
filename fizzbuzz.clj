; updated_at: Sun Sep 29 15:57:13 2013 JST
; > (load-file "fizzbuzz.clj")
;
(defn divisible? [n d] (== (mod n d) 0))
(defn fizz? [n] (divisible? n 3))
(defn buzz? [n] (divisible? n 5))
(defn fzbz? [n] (and (fizz? n) (buzz? n)))
(defn fizz-buzz? [n] (if (fzbz? n) "fizzbuzz"
                                   (if (buzz? n) "buzz"
                                                 (if (fizz? n) "fizz" n))))
(map #(fizz-buzz? %) (range 100))
