(ns pagerank.core
   (:gen-class))

   ;; This program displays Hello World
(defn Pages []
   (def string1 (slurp "C:/Users/tklinkenberg/Documents/CS441/Clojure_Project/CS441/pagerank/resources/pages_trim.txt"))
   (def string2 (clojure.string/split-lines string1))
   (def string3 (get string2 0))
   (def string4 (clojure.string/split string3 #" "))
   (def string5 (get string4 0))
   (Integer. (re-find  #"\d+" string5 )))
 
(Pages)
;; "C:/Users/tklinkenberg/Documents/CS441/Clojure_Project/CS441/pagerank/resources/pages.txt"
