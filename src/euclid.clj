(ns euclid)

(def pi Math/PI)
(defn delta [x0 x1] (- x1 x0))

(defn verify-nums 
  "Validates that all elements in xs are present and numeric.
  
  Throws an ExceptionInfo if:
    - any argument is nil
    - any argument is not a number" 
  [xs]
  (when (some nil? xs)
    (throw (ex-info "Argument is missing." {:args xs})))
  (when-not (every? number? xs)
    (throw (ex-info "Arguments must be numbers." {:args xs}))))

(defn sq 
  "Returns the square of x.
   
  Formula:
    x² = x * x" 
  [x]
  (verify-nums [x])
  (* x x))

(defn square-area
  "Returns the area of a square.
   
  Formula: 
     A = x² (or x * x)"
  [x]
  (sq x))

(defn square-perimeter 
  "Returns the perimeter of a square.
   
  Formula: 
     P = x * 4 (Sides of a square)"
  [x] 
  (verify-nums [x])
  (* x 4))

(defn rectangle-area 
  "Returns the area of a rectangle.
   
  Formula: 
     A = b * h"
  [b h] 
  (verify-nums [b h])
  (* b h))

(defn rectangle-perimeter 
  "Returns the perimeter of a rectangle.
   
  Formula: 
     P = 2 * (b + h)"
  [b h] 
  (verify-nums [b h])
  (* 2 (+ b h)))

(defn triangle?
  "Returns true if a, b, c can form a valid triangle.
  
  Conditions:
    - all sides must be positive
    - triangle inequality must hold"
  [a b c]
  (verify-nums [a b c])
  (and (every? pos? [a b c])
       (< a (+ b c))
       (< b (+ a c))
       (< c (+ a b))))

(defn identify-triangle
  "Determines the type of a triangle given sides a, b, c.
   
   Returns:
     :equilateral
     :isosceles
     :scalene"
  [a b c]
  (verify-nums [a b c])
  (when-not (triangle? a b c)
    (throw (ex-info "Not a valid triangle." {:sides [a b c]})))
  (cond
    (and (= a b) (= b c)) :equilateral
    (or (= a b) (= b c) (= a c)) :isosceles
    :else :scalene))

(defn triangle-area
  "Returns the triangle area using base and heigth.
   
  Formula: 
     A = b * h * 0.5 "
  [b h]
  (verify-nums [b h])
  (* 0.5 b h))
  
(defn triangle-perimeter
   "Returns the triangle perimeter.
   
  Formula: 
     p = a + b + c"
  [l0 l1 l2]
  (verify-nums [l0 l1 l2])
  (when-not (triangle? l0 l1 l2)
    (throw (ex-info "Not a valid triangle." {:sides [l0 l1 l2]})))
  (+ l0 l1 l2))

(defn semiperimeter
   "Returns half of a triangle perimeter.
   
  Formula: 
     s = (a + b + c) / 2"
  [a b c]
  (verify-nums [a b c])
  (/ (triangle-perimeter a b c) 2))

(defn heron-triangle-area
  "Returns the area of a triangle whose side lengths a, b, and c without heigth.

  Formula:
    A = √p(p -a)(p - b)(p - c)"
  [a b c]
  (let [p (semiperimeter a b c)]
    (Math/sqrt (* p 
                  (- p a)
                  (- p b) 
                  (- p c)))))

(defn pythagorean-theorem
  "Computes a missing side of a right triangle using the Pythagorean theorem.
  
  Formula: a² = b² + c²
  
  Parameters:
    - x, y: known sides
    - missing: which side to compute (:a, :b, or :c)
  
  Conventions:
    - :a ~> hypotenuse (computed from b and c)
    - :b ~> leg (computed from a and c)
    - :c ~> leg (computed from a and b)
  
  Note: does not currently guard against invalid domain (e.g., sqrt of negative)."
  [x y missing]
  (verify-nums [x y])
  (case missing
    :a (Math/sqrt (+ (sq x) (sq y))) ;; x = b, y = c
    :b (Math/sqrt (- (sq x) (sq y))) ;; x = a, y = c
    :c (Math/sqrt (- (sq x) (sq y))))) ;; x = a, y = b

(defn diameter-to-radius [d] (/ d 2))
(defn radius-to-diameter [r] (* r 2))

(defn circle-circumference 
  [x option]
  (verify-nums [x])
  (case option
    :d (* pi x)
    :r (* 2 pi x)
    (throw (ex-info "Option must be :d or :r" {:option option}))))

(defn circle-area
  [r]
  (verify-nums [r])
  (* pi (sq r)))

(defn points-distance
  [xa xb ya yb]
  (verify-nums [xa xb ya yb])
  (Math/sqrt (+ (sq (delta xa xb))
                (sq (delta ya yb)))))
