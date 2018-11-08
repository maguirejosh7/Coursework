;;; year_codes.el is a driver for function yearCode.
;;; Begun by: Dr. Adams, for CS 214 at Calvin College.
;;; Continued by Joshua Maguire on 2/21/14

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; yearCode returns the code for a given academic year.                 ;;;
;;; Receive: year, a string.                                             ;;;
;;; Precondition: year is one of {freshman, sophomore, junior or senior}.;;;
;;; Return: the integer code corresponding to year.                      ;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(defun yearCode (myYear)
"this is the yearCode function..."
(if (equal myYear "freshman")1
 (if (equal myYear "sophomore")2
  (if (equal myYear "junior")3
   (if (equal myYear "senior")4
   0 )))))




;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; main function                        ;;;
;;; input: year                          ;;;
;;; output: code corresponding to year   ;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defun main (year)
 (interactive "sEnter your academic year: ")  ; read year
 (message "%d" (yearCode year)))              ; display its code




;;; Tests...
(main "freshman")

(main "sophomore")

(main "junior")

(main "senior")

(main "rewsreg")






;;; year_codes.el is a driver for function yearCode.
;;; Begun by: Dr. Adams, for CS 214 at Calvin College.
;;; Continued by Joshua Maguire on 2/21/14

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; yearCode returns the code for a given academic year.                 ;;;
;;; Receive: year, a string.                                             ;;;
;;; Precondition: year is one of {freshman, sophomore, junior or senior}.;;;
;;; Return: the integer code corresponding to year.                      ;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(defun yearCode (myYear)
"this is the yearCode function..."
(if (equal myYear "freshman")1
 (if (equal myYear "sophomore")2
  (if (equal myYear "junior")3
   (if (equal myYear "senior")4
   0 )))))
yearCode



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; main function                        ;;;
;;; input: year                          ;;;
;;; output: code corresponding to year   ;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defun main (year)
 (interactive "sEnter your academic year: ")  ; read year
 (message "%d" (yearCode year)))              ; display its code
main



;;; Tests...
(main "freshman")
"1"


(main "sophomore")
"2"


(main "junior")
"3"


(main "senior")
"4"


(main "rewsreg")
"0"
