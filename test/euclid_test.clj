(ns euclid-test
  (:require
   [clojure.test :refer :all]
   [euclid :refer :all]))

(deftest verify-nums-test
  (testing "valid numbers"
    (is (nil? (verify-nums [1 2 3])))
    (is (nil? (verify-nums [0 0.5 -1]))))

  (testing "throws on nil"
    (is (thrown? clojure.lang.ExceptionInfo (verify-nums [1 nil 3]))))

  (testing "throws on non-number"
    (is (thrown? clojure.lang.ExceptionInfo (verify-nums [1 "a" 3])))))

(deftest rectangle-test
  (testing "rectangle area"
    (is (= 12 (rectangle-area 3 4)))
    (is (= 20 (rectangle-area 4 5))))

  (testing "rectangle perimeter"
    (is (= 14 (rectangle-perimeter 3 4)))
    (is (= 18 (rectangle-perimeter 4 5)))))

(deftest diameter-radius-test
  (testing "diameter/radius conversions"
    (is (= 2 (diameter-to-radius 4)))
    (is (= 10 (radius-to-diameter 5)))))

(deftest square-test
  (testing "square area"
    (is (= 16 (square-area 4)))
    (is (= 25 (square-area 5))))

  (testing "square perimeter"
    (is (= 16 (square-perimeter 4)))
    (is (= 20 (square-perimeter 5)))))

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
                 (triangle-perimeter 1 2 10)))))

(deftest heron-triangle-area-test
  (testing "area using Heron's formula"
    (is (= 6.0 (heron-triangle-area 3 4 5)))
    (is (= 4.47213595499958 (heron-triangle-area 3 3 4)))))

(deftest pythagorean-theorem-test
  (testing "hypotenuse and leg calculations"
    (is (= 5.0 (pythagorean-theorem 3 4 :a)))
    (is (= 3.0 (pythagorean-theorem 5 4 :b)))
    (is (= 4.0 (pythagorean-theorem 5 3 :c)))))
  
(deftest identify-triangle-test
  (testing "triangle types"
    (is (= :equilateral (identify-triangle 3 3 3)))
    (is (= :isosceles (identify-triangle 3 3 4)))
    (is (= :scalene (identify-triangle 3 4 5))))

  (testing "invalid triangle throws"
    (is (thrown? clojure.lang.ExceptionInfo
                 (identify-triangle 1 2 10)))))

(deftest circle-test
  (testing "circle circumference"
    (is (= (* pi 4) (circle-circumference 4 :d)))
    (is (= (* 2 pi 5) (circle-circumference 5 :r)))
    (is (thrown? clojure.lang.ExceptionInfo (circle-circumference 5 :x))))

  (testing "circle area"
    (is (= (* pi 9) (circle-area 3)))))

(deftest points-distance-test
  (testing "distance between points"
    (is (= 5.0 (points-distance 0 3 0 4)))
    (is (= 5.0 (points-distance 3 0 4 0)))))

(run-tests)