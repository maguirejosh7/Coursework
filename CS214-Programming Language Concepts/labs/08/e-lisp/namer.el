;;; namer.el simulates and tests an e-LISP Name type.
;;;
;;; Begun by: Dr. Adams, CS 214 at Calvin College.
;;; Completed by:Joshua Maguire
;;; Date:4/13/14
;;;
;;;used M-x byte-compile, then entered pathname, remember double //


(add-to-list 'load-path "C:\\Users\magui_000\Desktop\08\e-lisp")
("C:\\Usersmagui_000Desktop 8-lisp" "." "c:/Users/magui_000/Desktop/emacs-24.3/site-lisp" "c:/Users/magui_000/Desktop/site-lisp" "c:/Users/magui_000/Desktop/emacs-24.3/lisp" "c:/Users/magui_000/Desktop/emacs-24.3/lisp/vc" "c:/Users/magui_000/Desktop/emacs-24.3/lisp/url" "c:/Users/magui_000/Desktop/emacs-24.3/lisp/textmodes" "c:/Users/magui_000/Desktop/emacs-24.3/lisp/progmodes" "c:/Users/magui_000/Desktop/emacs-24.3/lisp/play" "c:/Users/magui_000/Desktop/emacs-24.3/lisp/org" "c:/Users/magui_000/Desktop/emacs-24.3/lisp/nxml" ...)


(load "Name.elc")
t


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
  (terpri buf))                              ; newline


John Paul Jones
All tests passed!
t
