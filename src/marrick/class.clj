(ns marrick.class)

(defn apply-message-to  [class instance message args]
  (let [method (message (:__instance_methods__ class))] (apply  method instance args)))



(def make
     (fn [class & args]
       (let [seeded {:__class_symbol__ (:__own_symbol__ class)}]
         (apply-message-to class seeded :add-instance-values  args))))

(def send-to
     (fn [instance message & args]
       (let [class (eval (:__class_symbol__ instance))]
         (apply-message-to class  instance message args))))


; (apply-message-to Point a-point :shift [1 3]) 

(def Point
{
  :__own_symbol__ 'Point
  :__instance_methods__
  {
    :add-instance-values (fn [this x y]
                           (assoc this :x x :y y))
    :class :__class_symbol__
    :shift (fn [this xinc yinc]
             (make Point (+ (:x this) xinc)
                         (+ (:y this) yinc)))
    :add (fn [this other]
           (send-to this :shift (:x other)
                                (:y other)))
   }
 })


;; For exercise 4
(def Holder  
{
  :__own_symbol__ 'Holder
  :__instance_methods__
  {
    :add-instance-values (fn [this held]
                           (assoc this :held held))
  }
})

