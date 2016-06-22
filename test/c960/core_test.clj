(ns c960.core-test
  (:require [clojure.test :refer :all]
            [c960.core :refer :all]))

(deftest test-bishops-legal?
  (testing "Given an even number of pieces between Bishops return true."
    (is (bishops-legal? [\u2656 \u2658 \u2657 \u2655 \u2654 \u2657 \u2658 \u2656])))
  (testing "Given an odd number of pieces between Bishops return false."
    (is (not (bishops-legal? [\u2656 \u2658 \u2657 \u2655 \u2658 \u2654 \u2657  \u2656]))))
  (testing "Given one or no Bishop return false."
    (is (not (bishops-legal? [\u2656 \u2658 \u2657 \u2655 \u2654])))
    (is (not (bishops-legal? [\u2656 \u2658 \u2655 \u2654 \u2658 \u2656])))))


(deftest test-king-legal?
  (testing "Given the King is between two rooks return true"
    (is (king-legal? [\u2656 \u2658 \u2657 \u2655 \u2654 \u2657 \u2658 \u2656])))
  (testing "Given the King is not between two rooks return false"
    (is (not (king-legal? [\u2656 \u2658 \u2657 \u2655 \u2654 \u2657 \u2658])))
    (is (not (king-legal? [\u2656 \u2656 \u2658 \u2657 \u2655 \u2654 \u2657 \u2658])))
    (is (not (king-legal? [\u2658 \u2657 \u2655 \u2654 \u2657 \u2658])))
    (is (not (king-legal? [\u2658 \u2657 \u2655 \u2657 \u2658])))))
