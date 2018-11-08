;;; grades.el computes the function for this lab...  
;;; Completed by:Joshua Maguire
;;; Date:2/26/14
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;                   



;;;this function, given average grade, returns letter grade
;;;parameter: myGrade, an int
;;;return: char of letter grade
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defun computeGrades(myGrade)
  (case (/ myGrade 10) (10 'A)
    (9 'A) 
    (8 'B) 
    (7 'C) 
    (6 'D)
    (t 'F)
  ))

(defun grades(myGrade)
  "test computeGrades(myGrade)"
  (interactive "Average:")
  (setq result (computeGrades myGrade))
  (message "letter grade:" result))
