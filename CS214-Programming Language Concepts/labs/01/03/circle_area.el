;; This buffer is for notes you don't want to save, and for Lisp evaluation.
;; If you want to create a file, first visit that file with C-x C-f,
;; then enter the text in that file's own buffer.

;;; circle_area.el computes the area of a circle. 
;;;                                                                     
;;; Input: The radius of the circle.                                    
;;; Precondition: The radius is a positive number.                      
;;; Output: The area of the circle.                                     
;;; 
;;; Begun by: Dr. Nelesen, for CS 214 at Calvin College.
;;; Completed by:
;;; Date:
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;                   

;;; function circleArea computes a circle's area, given its radius.     
;;; Parameters: r, a number.                                            
;;; Precondition: r >= 0.                                               
;;; Returns: the area of the circle whose radius is r.                   
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;                  
(defun circleArea (radius);define circleArea
  "Compute the area of a circle, passed its radius."
  (defconst PI 3.1415927);make var PI
  (* PI (* radius radius))) ;do maths



(defun circle_area(r)  ;define fnction
 "Compute the area of a circle, given its radius interactively."
  (interactive "nRadius: ") ;define interactive nRadius       
  (setq area (circleArea r))   ;set variable area to (run circleArea)   
  (message "The circle's area is %f." area)) ; disp data

