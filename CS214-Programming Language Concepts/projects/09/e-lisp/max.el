;;; Begun by: Dr. Adams, CS 214 at Calvin College.
;;; Completed by:Joshua Maguire
;;; Date: 4/28/14

(add-to-list 'load-path ".")

("." "c:/Users/Admin/Desktop/emacs-24.3/site-lisp" "c:/Users/Admin/Desktop/site-lisp" "c:/Users/Admin/Desktop/emacs-24.3/lisp" "c:/Users/Admin/Desktop/emacs-24.3/lisp/vc" "c:/Users/Admin/Desktop/emacs-24.3/lisp/url" "c:/Users/Admin/Desktop/emacs-24.3/lisp/textmodes" "c:/Users/Admin/Desktop/emacs-24.3/lisp/progmodes" "c:/Users/Admin/Desktop/emacs-24.3/lisp/play" "c:/Users/Admin/Desktop/emacs-24.3/lisp/org" "c:/Users/Admin/Desktop/emacs-24.3/lisp/nxml" "c:/Users/Admin/Desktop/emacs-24.3/lisp/net" ...)

(load-file "mylist.elc")                      ; load modul


;;;;;;;;;;;;;;;;;;;;;;;;;
;;; test function Max. ;;
;;;;;;;;;;;;;;;;;;;;;;;;;
(progn
  (let
    ((buf (get-buffer "max.el"))        ; setup for output
      (list1 (list 99 88 77 66 55))     ; max is first
      (list2 (list 55 66 77 88 99))     ; max is last
      (list3 (list 55 77 99 88 66))     ; max in middle
      (list4 (list 44 88 77 66 55)))
    (princ list1 buf)                    ; print list1
    (terpri buf)                         ;  and a newline

    (princ list2 buf)                    ; print list2
    (terpri buf)                         ;  and a newline

    (princ list3 buf)                    ; print list3
    (terpri buf)                         ;  and a newline
  
    (princ "The max in list 1 is " buf)  ; print the max
    (princ (Max list1) buf)              ;  in list1
    (terpri buf)                         ;  and a newline
    (princ "The max in list 2 is " buf)  ; print the max
    (princ (Max list2) buf)              ;  in list2
    (terpri buf)                         ;  and a newline
    (princ "The max in list 3 is " buf)  ; print the max
    (princ (Max list3) buf)              ;  in list3
    (terpri buf)                       ;  and a newline
    ;;;;;;;;;;;;search tests;;;;;;;;;;
    (princ (search list1 99 0) buf)
    (terpri buf)
    (princ (search list2 99 0) buf)
    (terpri buf)
    (princ (search list3 99 0) buf)
    (terpri buf)
    (princ (search list4 99 0) buf)
    (terpri buf)


))

(99 88 77 66 55)
(55 66 77 88 99)
(55 77 99 88 66)
The max in list 1 is 99
The max in list 2 is 99
The max in list 3 is 99
0
4
2
-1
t
