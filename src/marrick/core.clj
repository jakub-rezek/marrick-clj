(ns marrick.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

;;; pg 19/35/339

(defn my-second [list]
  (first (rest list)))

(defn my-third [list]
  (first (rest (rest list))))


;;; pg 24/40/339

(defn my-apply [fn seq]
  (eval (cons fn seq)))

;;; pg 26/42

(defn my-sqr [n]
  (* n n))

(defn add-squares [& numbers]
  (apply + (map my-sqr numbers)))

(defn factorial [n]
  (apply * (map inc (range n))))

;;; 

