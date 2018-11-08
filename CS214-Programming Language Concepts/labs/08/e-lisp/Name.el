;;; namer.el simulates and tests an e-LISP Name type.
;;;
;;; Begun by: Dr. Adams, CS 214 at Calvin College.
;;; Completed by:Joshua Maguire
;;; Date:4/13/14
;;;


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Name constructs a name from three strings.      ;;
;;; Receive: first, middle and last, three strings. ;;
;;; Return: the triplet (first middle last).        ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defun Name(first middle last)
  (list first middle last) )


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; getFirst extracts the first name of a name object.;
;;; Receive: theName, a Name.                       
;;; Return: the first string in theName.           
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defun getFirst(theName)
  (car theName) )

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; getMiddle extracts the middle name of a name object.
;;; Receive: theName, a Name.                      
;;; Return: the second string in theName.           
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defun getMiddle(theName)
  (car (cdr theName) ) )

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; getLast extracts the last name of a name object.
;;; Receive: theName, a Name.                    
;;; Return: the third string in theName.       
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defun getLast(theName)
  (car (cdr (cdr theName) ) ) )

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; getFullName returns a full name in F-M-L order. 
;;; Return: myFirst, myMiddle, myLast.           
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defun getFullName (theName)
   (concat (getFirst theName) " " (getMiddle theName) " " (getLast theName) ))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; printName displays a name object.         
;;; Receive: theName, a Name,                 
;;;          buffer, the name of a buffer.   
;;; Output: the strings in theName to buffer. ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defun printName (theName buf)
   (princ (getFullName theName) buf)
   theName )
