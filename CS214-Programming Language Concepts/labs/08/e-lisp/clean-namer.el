;;; namer.el simulates and tests an e-LISP Name type.
;;;
;;; Begun by: Dr. Adams, CS 214 at Calvin College.
;;; Completed by:Joshua Maguire
;;; Date:4/13/14
;;;
;;;used M-x byte-compile, then entered pathname, remember double //


(add-to-list 'load-path "C:\\Users\magui_000\Desktop\08\e-lisp")

(load "Name.elc")


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;; A simple driver for our Name functions. ;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(progn
  (require 'cl)                              ; Common Lisp's assert
  (setq aName (Name "John" "Paul" "Jones"))  ; build a Name

  (assert (equal (getFirst aName) "John" ))  ; test it
  (assert (equal (getMiddle aName) "Paul" ))
  (assert (equal (getLast aName) "Jones" ))
  (assert (equal (getFullName aName) "John Paul Jones" ))

  (setq buf (get-buffer "namer.el"))         ; buf = this buffer
  (assert (eq (printName aName buf) aName) )
  (terpri buf)                               ; newline
  (princ "All tests passed!")                ; feedback
  (terpri buf))   
