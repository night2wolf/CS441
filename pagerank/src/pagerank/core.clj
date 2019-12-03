(ns pagerank.core
   (:gen-class))
(import 'java.util.concurrent.ExecutorService)
(import '(java.util.concurrent Executors))

;; arrays for the output and pagerank
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
(defn Pagerankcompute [threads]
   (def nthreads (Executors/newFixedThreadPool threads))
   (set-agent-send-executor! nthreads)
     (dotimes [y 10000] 
      (def page3 (nth string2 y))
      (def page4 (clojure.string/split page3 #" "))
      (dotimes [c (count page4)]
         (def page5 (nth page4 c))
         (def page6 (Integer. (re-find  #"\d+" page5 )))
         (def ct (aget outputlist (int page6)))
         (def comppr (+ 0.15 (* 0.85 (/ y ct))))
         (aset-float pageranklist page6 comppr))))
;; display the final output times and threads
(spit "output.txt" "Single Thread:\n")
(spit "output.txt" (with-out-str (time (send (agent 0) (Pagerankcompute 1)))) :append true)
(spit "output.txt" "Two Threads:\n" :append true)
(spit "output.txt" (with-out-str (time (send (agent 0) (Pagerankcompute 2)))) :append true)
(spit "output.txt" "Four Threads:\n" :append true)
(spit "output.txt" (with-out-str (time (send (agent 0) (Pagerankcompute 4)))) :append true)
(spit "output.txt" "Eight Threads:\n" :append true)
(spit "output.txt" (with-out-str (time (send (agent 0) (Pagerankcompute 8)))) :append true)
(spit "output.txt" "Sixteen Threads:\n" :append true)
(spit "output.txt" (with-out-str (time (send (agent 0) (Pagerankcompute 16)))) :append true)
(spit "output.txt" "Thirty-Two Threads:\n" :append true)
(spit "output.txt" (with-out-str (time (send (agent 0) (Pagerankcompute 32)))) :append true)
(spit "output.txt" "Sixty-Four Threads:\n" :append true)
(spit "output.txt" (with-out-str (time (send (agent 0) (Pagerankcompute 64)))) :append true)

;; "C:/Users/tklinkenberg/Documents/CS441/Clojure_Project/CS441/pagerank/resources/pages.txt"