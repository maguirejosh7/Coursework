;;lab10.el exercises
;;by Joshua Maguire
;;5/4/14

(lambda (x) (+ x x))
(lambda (x) (+ x x))

((lambda (x) (+ x x)) 17)
34

;;EXERSIZE 1a:
((lambda (w x y z) (max (abs w) (abs x) (abs y) (abs z))) -2 3 5 -6.7)
6.7

;;EXERSIZE 1b:
((lambda (x y z) (+ x y z)) 1 2 3) ;;...
6

((lambda (x) (null x)) nil) ;;true if sent null
t

((lambda () 17.2) ) ;; this guy doesn't take any inputs
17.2

;;EXCERSIZE ... Part 2

;; (function abs) / #'abs both return the function abs.

;;this shouldn't work
(setq double (function (lambda (x) (+ x x))))
(double 11)

;;but this should
(funcall double 11)
22

;;triple
((lambda (x) (+ x (+ x x)))11)
33
(setq triple (function (lambda (x) (+ x (+ x x))) ) )
(funcall triple 11)
33

;;EXERSIZE 2
 (defun subtract-n (n list)
   	(mapcar #'(lambda (x) (- x n)) list))
subtract-n

(subtract-n 2 '(2 4 6))
(0 2 4)

(defun sum-squares (list)
 ;; (mapcar #'(lambda (x) (* x x)) list) ;;add each square of each element of a list together.
  ;;(apply #'+ list) ;;returns number: sum of list
  (apply #'+ (mapcar #'(lambda (x) (* x x)) list) )
)
sum-squares

   (sum-squares '(1 2 3))          ; should return 14
14

   (sum-squares '(1 2 3 4 5))      ; should return 55
55

   (sum-squares '(-1 -2 -3 0 1))   ; should return 15 
15
