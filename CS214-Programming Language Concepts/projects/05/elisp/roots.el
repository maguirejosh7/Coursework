; roots.cpp computes the roots of a quadratic equation 
;
; Input: three terms of quadratic equation ( y = ax^2 + bx + c )
; PRE: a > 0, (b^2 - 4ac) != negative
; Output: x = root1, x = root2
;
; Begun by: Dr. Adams, for CS 214 at Calvin College.
; Completed by:Joshua Maguire
; Date:3/13/14
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;




(defun quadraticRoots (a b c)
  (if (/= a 0); if a != 0
    (progn ;do next two lines
      (setq arg (- (expt b 2.0) (* 4 (* a c))))
      (if (>= arg 0.0) t) ;return true if arg is >= 0, else return nil
    )
  )
)



(defun main (rootA rootB rootC)
  (interactive "nEnter first term for quadratic equation: \nnSecond: \nnThird:")
  (if (quadraticRoots rootA rootB rootC)  ;if true,
    (progn                                ;do this. else, down to message
      (setq root1 (/ (+ (- 0 rootB) (sqrt arg)) (* 2 rootA)))
      (setq root2 (/ (- (- 0 rootB) (sqrt arg)) (* 2 rootA)))
      (message "x = %f, x = %f" root1 root2)
    )
    (message "rootA was 0 or the discriminant was less than 0!") ;;;else message..could do math here to check if was discriminant or 0 problem, but sort of redundant... also, if you didn't type 0 as rootA, then the problem must be with the discriminant being less than 0...
  )
)



