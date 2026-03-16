(ns euclid-test
  (:require
   [clojure.test :refer :all]
   [euclid :refer :all]))

(deftest square-test
  (testing "square area"
    (is (= 16 (square-area 4)))
    (is (= 25 (square-area 5))))

  (testing "square perimeter"
    (is (= 16 (square-perimeter 4)))
    (is (= 20 (square-perimeter 5)))))

(deftest rectangle-test
  (testing "rectangle area"
    (is (= 12 (rect-area 3 4)))
    (is (= 20 (rect-area 4 5))))

  (testing "rectangle perimeter"
    (is (= 14 (rect-perimeter 3 4)))
    (is (= 18 (rect-perimeter 4 5)))))

(deftest triangle-test
  (testing "triangle validity"
    (is (true? (triangle? 3 4 5)))
    (is (false? (triangle? 1 2 10))))

  (testing "triangle area using base and height"
    (is (= 6.0 (triangle-area 3 4)))
    (is (= 10.0 (triangle-area 4 5))))

  (testing "triangle perimeter"
    (is (= 12 (triangle-perimeter 3 4 5))))

  (testing "invalid triangle throws exception"
    (is (thrown? clojure.lang.ExceptionInfo
                 (triangle-perimeter 1 2 10))))

  (testing "compute hypotenuse"
    (is (= 5.0 (pythagorean-theorem 3 4 :a))))

  (testing "compute leg"
    (is (= 3.0 (pythagorean-theorem 5 4 :b)))
    (is (= 4.0 (pythagorean-theorem 5 3 :c)))))