# euclid

> [!NOTE]
> This project is currently minimal and under development.

⚛︎ A small library that implements Euclidean geometry. 

## Functionalities

- Square (area, perimeter)
- Rectangle (area, perimeter)
- Triangle (area, perimeter, Pythagorean theorem)

## Usage Method

### Clone the repository

```bash
git clone https://github.com/gusutabo/euclid.git
cd euclid
```

### Run in REPL

```clojure
(require '[euclid :as e])

(e/square-area 4)
;; => 16

(e/rect-perimeter 3 4)
;; => 14

(e/triangle? 3 4 5)
;; => true

(e/pythagorean-theorem 3 4 :a)
;; => 5.0
```

## Goal

The goal of this project is to explore mathematical concepts through functional programming, using Clojure to implement and understand fundamental ideas from Euclidean geometry and beyond.

## License

This project is licensed under the MIT License.
