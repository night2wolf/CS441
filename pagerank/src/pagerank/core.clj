(ns pagerank.core
   (:gen-class))
(def outputlist (make-array Integer/TYPE 30))
(def pageranklist (make-array Float/TYPE 10000))
;; breaks down a row and returns it as an integer.
;; //reference for later when building up lists. parse each row.
(def string1 (slurp "C:/Users/tklinkenberg/Documents/CS441/Clojure_Project/CS441/pagerank/resources/pages_trim.txt"))
(def string2 (clojure.string/split-lines string1))
   ;;(def string3 (nth string2 0))
   ;;(def string4 (clojure.string/split string3 #" "))
   ;;(def string5 (nth string4 9 "nothing found"))
   ;;(if (= string5 "nothing found")
   ;;10001
   ;; (Integer. (re-find  #"\d+" string5 ))))

   ;; while loop to populate the output list
(defn populateoutputlist []
   (dotimes [x 21]       
      (def string3 (nth string2 x))
      (def string4 (clojure.string/split string3 #" "))
      (def sz (count string4))
      (aset outputlist x sz)))
(populateoutputlist)
;; displays the array
(seq outputlist)

;; "C:/Users/tklinkenberg/Documents/CS441/Clojure_Project/CS441/pagerank/resources/pages.txt"