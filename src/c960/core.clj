(ns c960.core
  (:gen-class)
  (:require [clojure.string :as s]))

;; legal starting rank - unicode chars for rook, knight, bishop, queen, king, bishop, knight, rook
(def starting-rank [\u2656 \u2658 \u2657 \u2655 \u2654 \u2657 \u2658 \u2656])

(defn bishops-legal?
  "True if Bishops are odd number of indicies apart"
  [rank]
  (odd? (apply - (cons 0 (sort > (keep-indexed #(when (= \u2657 %2) %1) rank))))))

(defn king-legal?
  "True if the king is between two rooks"
  [rank]
  (let [king-&-rooks (filter #{\u2654 \u2656} rank)]
    (and
     (= 3 (count king-&-rooks))
     (= \u2654 (second king-&-rooks)))))


(defn c960
  "Return a legal rank for c960 chess"
  []
  (->> #(shuffle starting-rank)
       repeatedly
       (filter #(and (king-legal? %) (bishops-legal? %)))
       (take 1)
       first
       (s/join ", ")))


(comment

  (c960)
  ;; => ([:R :N :B :B :Q :K :R :N])

  )
;; => nil