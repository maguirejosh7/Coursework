;;; mylist.el is a "module" of list operations.
;;;
;;; Begun by: Dr. Adams, CS 214 at Calvin College.
;;; Completed by: Joshua Maguire
;;; Date:   4/28/14

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Max 2 finds the maximum of two values.      ;;
;;; Receive: val1, val2, two values.            ;;
;;; PRE: val1 and val2 can be compared using <. ;;
;;; Return: the maximum of val1 and val2.       ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defun Max2(val1 val2)
  (if (> val1 val2)
      val1
    val2)
  )
Max2


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; Max finds the maximum value in a list.         ;;
;;; Receive: aList, a list of values.              ;;
;;; PRE: values in aList can be compared using <.  ;;
;;; Return: the maximum value in aList.            ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defun Max(aList)
  (if (listp aList)
   (if (equal (length aList) 1) (car aList) 
    (Max2 (car aList) (Max (cdr aList))))
   nil)
)
Max



(defun length (aList)
       (if (listp aList)
          (if (null aList)
             0
          (+ 1 (length (cdr aList))))
        nil)
)
length

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
 ; search() searches a list for a specified  ;
 ;int.										; 
 ; Receive: aList, a list of integers,       ;
 ;     aValue, int being searched for   
 ;      position, starting position of search,
 ; Output: position of found int, -1 if      ;
;                      		  not found  ;
 ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defun search (aList aValue position)
  (if (equal (equal (car aList) nil) nil)
    (if (equal aValue (car aList)) ;then1
      position ;then2... return this
      (search (cdr aList) aValue (+ position 1))    ;else2
    ) 
  -1
  ) ;else1
  
)



search
