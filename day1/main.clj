(require '[clojure.string :as s])

(def input 
     (mapv #(Integer/parseInt %) (s/split-lines (slurp "input"))))

(def solve
    (second (first (->> input
                        (map-indexed (fn [i x] [x, (drop (inc i) input)]))
                        (mapcat (fn [[x ys]] (map (fn [y] [(+ x y) (* x y)]) ys)))
                        (filter (fn [[sum prod]] (= sum 2020)))))))

(println solve)