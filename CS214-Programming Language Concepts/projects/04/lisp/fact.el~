; fact.cpp displays the factorial of a positive number n.
; Input: unsigned n
; PRE: positive integer
; Output: factorial of the number
; Begun by Professor Adams? for CS 214 at Calvin COllege
; Edited by Joshua Maguire
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; computeFact  computes the factorial of a positive number n.
; Input: i (counting variable) and answer (starts as 1, returns factorial answer)
; PRE: i is positive integer
; Output: factorial of i (returned through variable answer)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defun computeFact(i answer)
 ;Documentation above..
  (if(>= i 2) ;if /for loop
    (progn
    (setq answer (* i answer)) ;*= answer
    (setq i (- i 1))        ;decrement counter
    (computeFact i answer)  ;recursion loop
    )
  answer) ; else return answer, which defaults as 1
)
computeFact


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; main is a 'driver' for fact()               	       ;;;
;;; Documentation is at top of file..	                       ;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defun main (n)
  "documentation above..."
   (interactive "nTo compute n!, enter n: ")
   (message "%d" (computeFact n 1)))
main

;tests
(main 2)
"2"
(main 3)
"6"
(main 4)
"24"
(main 5)
"120"
