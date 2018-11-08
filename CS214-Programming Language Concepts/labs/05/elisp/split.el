;;; split.el splits a string into two substrings.
;;;
;;; Input: aString, the string to be split,
;;;        pos, the split position.
;;; Output: the substring of aString before pos, and
;;;         the substring of aString from pos onwards.
;;;
;;; Begun by: Dr. Adams, for CS 214 at Calvin College.
;;; Completed by:Joshua Maguire
;;; Date:3/9/14
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;:;
;;; split() splits a string into its two substrings.  
;;; Receive: aString, the string to be split,         
;;;        pos, the split position.                   
;;; PRE: 0 <= pos < the length of aString.
;;; Return: the substring of aString before pos, and  
;;;         the substring of aString from pos onwards.
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defun split(theString position)
"split theString into substrings parta,b, passed theString and a spliting position"
 (setq part1 (substring theString 0 position)) ;set part1 to (create substring from theString)
 (setq part2 (substring theString position));^^
 (list part1 part2);creaete a list of the 2 substrings and return
)


(defun main (aString pos)
  (interactive "sEnter the string to be split: \nnEnter the split position")
  (setq result (split aString pos))
  (setq part1 (elt result 0))
  (setq part2 (elt result 1))
  (message "The first part is %s and the second part is %s" part1 part2))


(main "hello" 0)

(main "hello" 3)

(main "hello" 5)
