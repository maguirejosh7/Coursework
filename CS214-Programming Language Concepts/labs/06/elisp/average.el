;;; average.el "test-drives" function average().
;;; Output: the average of a sequence of numbers.
;;;
;;; Begun by: Dr. Adams, CS 214 at Calvin College.
;;; Completed by:Joshua Maguire
;;; Date: 3/21/14
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; sum() sums the values in an array.         ;;
;;; Receive: anArray, an array of numbers,   ;;
;;;          itsSize, its size.              ;;
;;; Return: the sum of the values in anArray.;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defun sum (anArray itsSize)
  (if (vectorp anArray); if its an array
      (if (<= itsSize 0) ;if size too small,
          0.0                       ;return 0.0
        (+ (aref anArray (- itsSize 1)) (sum anArray (- itsSize 1))))
    nil))
sum


 ;but otherwise, anArray[mysize-1] + sum(mysize-1) ...-1 because index starts at 0.


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; average() computes the average of an array of numbers.;;
;;; Receive: anArray, an array of numbers.              ;;
;;; Return: the average of the numbers.                 ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defun average (anArray)
  (if (vectorp anArray);if its an array
      (if (<= (length anArray) 0) 
	  0.0;if array length <= 0, return 0.0
	(/ (sum anArray (length anArray)) (length anArray)) ;else do this...
	)
    ))
average


;;; Test function sum
(sum [] 0)
0.0

(sum [9.0 8.0 7.0 6.0] 4)
30.0

;;; Test function average
(average [])
0.0


(average [9.0 8.0 7.0 6.0])
7.5