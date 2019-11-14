(ns pagerank.core
   (:gen-class))
(defn Pages []
   (with-open [rdr (clojure.java.io/reader "resources/pages.txt")]
   (reduce conj [] (line-seq rdr))))
(Pages)
;; "C:/Users/tklinkenberg/Documents/CS441/Clojure_Project/pagerank/resources/pages.txt"
