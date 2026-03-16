(ns euclid)

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

(defn triangle? 
  [a b c]
  (verify-nums [a b c])
  (and (< a (+ b c))
       (< b (+ a c))
       (< c (+ a b))))

(defn sq [x] 
  (verify-nums [x])
  (* x x))

(defn square-area [x] (sq x))
(defn square-perimeter 
  [x] 
  (verify-nums [x])
  (* x 4))

(defn rect-area
  [b h] 
  (verify-nums [b h])
  (* b h))

(defn rect-perimeter 
  [b h] 
  (verify-nums [b h])
  (* 2 (+ b h)))

(defn triangle-area
  [b h]
  (verify-nums [b h])
  (* 0.5 b h))
  
(defn triangle-perimeter
  [l0 l1 l2]
  (verify-nums [l0 l1 l2])
  (when-not (triangle? l0 l1 l2)
    (throw (ex-info "Not a valid triangle." {:sides [l0 l1 l2]})))
  (+ l0 l1 l2))

(defn pythagorean-theorem
  ;; a² = b² + c²
  ;; :a -> compute a from b and c
  ;; :b -> compute b from c and a 
  ;; :c -> compute c from a and b
  [x y missing]
  (verify-nums [x y])
  (case missing
    :a (Math/sqrt (+ (sq x) (sq y)))
    :b (Math/sqrt (- (sq x) (sq y)))
    :c (Math/sqrt (- (sq x) (sq y)))))
