(ns marrick.add-and-make)

(def point {:x 1, :y 2, :__class_symbol__ 'Point})

(def Point
     (fn [x y]
       {:x x,
        :y y
        :__class_symbol__ 'Point}))

(def x :x)
(def y :y)
(def class-of :__class_symbol__)

(def shift
     (fn [this xinc yinc]
       (Point (+ (x this) xinc)
              (+ (y this) yinc))))

(def Triangle
     (fn [point1 point2 point3]
       {:point1 point1, :point2 point2, :point3 point3
        :__class_symbol__ 'Triangle}))


(def right-triangle (Triangle (Point 0 0)
                              (Point 0 1)
                              (Point 1 0)))

(def equal-right-triangle (Triangle (Point 0 0)
                                    (Point 0 1)
                                    (Point 1 0)))

(def different-triangle (Triangle (Point 0 0)
                                  (Point 0 10)
                                  (Point 10 0)))


;;; exercises

(defn add [p-1 p-2]
  (Point (+ (x p-1) (x p-2))
         (+ (y p-1) (y p-2))))

(defn add-shift [this p-2]
  (shift this (x p-2) (y p-2))) 

(defn make [fn & args]
  (apply fn args))

(defn equal-triangle? [& more]
  (apply = more) )
