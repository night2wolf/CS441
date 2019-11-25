(ns pagerank.core
   (:gen-class))
(def outputlist (make-array Integer/TYPE 10000))
(def pageranklist (make-array Float/TYPE 10000))
;; Read in file and split into vectors per line
(def string1 (slurp "C:/Users/tklinkenberg/Documents/CS441/Clojure_Project/CS441/pagerank/resources/pages.txt"))
(def string2 (clojure.string/split-lines string1))
;; populate all the page ranks with a beginning value of 1
(defn populateprlist []
   (dotimes [z 10000]
      (aset-float pageranklist z 1)))
(populateprlist)
;; while loop to populate the output list
(defn populateoutputlist []
   (dotimes [x 10000]       
      (def string3 (nth string2 x))
      (def string4 (clojure.string/split string3 #" "))
      (def sz (count string4))
      (aset outputlist x sz)))
(populateoutputlist)
;;compute the page rank
(defn Pagerankcompute []
   (dotimes [y 10000] 
   (def page3 (nth string2 y))
   (def page4 (clojure.string/split page3 #" "))
   (dotimes [c (count page4)]
      (def page5 (nth page4 c))
      (def page6 (Integer. (re-find  #"\d+" page5 )))
      (def ct (aget outputlist (int page6)))
      (def comppr (+ 0.15 (* 0.85 (/ y ct))))
      (aset-float pageranklist page6 comppr))))
(Pagerankcompute)
;; display the final output list and pageranks
(print (seq pageranklist))
(print (seq outputlist))

;; "C:/Users/tklinkenberg/Documents/CS441/Clojure_Project/CS441/pagerank/resources/pages.txt"
