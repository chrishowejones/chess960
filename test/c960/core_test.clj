(ns c960.core-test
  (:require [clojure.test :refer :all]
            [c960.core :refer :all]))

(deftest test-bishops-legal?
  (testing "Given an even number of pieces between Bishops return true."
    (is (bishops-legal? [:R :N :B :K :Q :B :N :R])))
  (testing "Given an odd number of pieces between Bishops return false."
    (is (not (bishops-legal? [:R :N :B :K :Q :N :B :R]))))
  (testing "Given one or no Bishop return false."
    (is (not (bishops-legal? [:R :N :B :K :Q :N :R])))
    (is (not (bishops-legal? [:R :K :K :Q :N :R])))))


(deftest test-king-legal?
  (testing "Given the King is between two rooks return true"
    (is (king-legal? [:R :K :B :B :R :N :N])))
  (testing "Given the King is not between two rooks return false"
    (is (not (king-legal? [:R :K :B :B :N :N])))
    (is (not (king-legal? [:R :R :K :B :B :N :N])))))
