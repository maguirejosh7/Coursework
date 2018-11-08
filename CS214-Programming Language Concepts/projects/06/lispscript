 ;arrays.el reads in a user-specified amount of values into an array, then prints them out. Driver driven. 
 ;
 ; Begun by: Dr. Adams, for CS 214 at Calvin College.
 ; Completed by: Joshua Maguire
 ; Date:4/8/14
 ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 
 
 ; readArray reads in an arrays contents.
 ; Input: double array anArray, int size, istream
 ; Output:
 ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defun readArray (itsSize theArray)
  (if (vectorp theArray) ;if its an array
      (if (> itsSize -1) ;and if size is >= 0
	 (progn
	   (setq (aref theArray itsSize) (interactive "nEnter array contents:"))
	   (readArray (- itsSize 1) theArray);set theArray at itsSize to (user input), then call readArray at itsSize-1...didn't work?
	 )
      )  
  )
)
readArray


;; printArray prints an arrays contents.
;; Input: double array anArray, int size, ostream
;; Output: arrays contents
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defun printArray (itsSize theArray)
  ( if ( vectorp theArray )
    (if (> itsSize theArray)
	;print array at its Size
	;call printArray at itsSize-1
    )
  )
)
printArray
  

(defun main (arraySize)
	(interactive "nEnter the array size:")
	(setq anArray(make-vector arraySize 0))
	(readArray arraySize anArray)
	(readArray arraySize  (aref anArray (- arraySize 1)))
)
main

;(readArray (- itsSize 1)  (aref theArray (- itsSize 1)))

;progn: Wrong type argument: symbolp, (aref theArray itsSize)