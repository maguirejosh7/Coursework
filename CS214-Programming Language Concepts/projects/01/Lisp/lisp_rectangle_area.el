;; This buffer is for notes you don't want to save, and for Lisp evaluation.
;; If you want to create a file, first visit that file with C-x C-f,
;; then enter the text in that file's own buffer.

;;; rectangle_area.el computes the area of a rectangle. 
;;;                                                                     
;;; Input: The sides of the rectangle.                                    
;;; Precondition: The sides are positive numbers.                      
;;; Output: The area of the rectangle.                                     
;;; 
;;; Begun by: Dr. Nelesen, for CS 214 at Calvin College.
;;; Completed by:Joshua Maguire
;;; Date:2/10/14
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;                   

;;; function rectangleArea computes a rectangles's area, given its sides.     
;;; Parameters: l,w,  numbers.                                            
;;; Precondition: l,w >= 0.                                               
;;; Returns: the area of the rectangle whose sides are l,w.                   
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;                  
(defun rectangleArea (l w);define rectangleArea
  "Compute the area of a rectangle, passed its sides."
  (* w l ) ) ;do maths and done.

(defun rectangle_area(l w)  ;define fnction
 "Compute the area of a rectangle, given its length and width  interactively."
  (interactive "nLength:  \nnWidth:" ) ; take in l and w on seperate lines       
  (setq area (rectangleArea l w))   ;set variable area to (run circleArea)   
  (message "The rectangles's area is %f." area)) ; disp data




