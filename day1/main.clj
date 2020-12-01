(require '[clojure.string :as s])

(def input 
     (mapv #(Integer/parseInt %) (s/split-lines (slurp "input"))))

(doseq [x input]
  (let [results (into []
                      (comp
                        (map (fn [y] [(+ x y) (* x y)]))
                        (filter (fn [y] (= (first y) 2020))))
                      input)]
    (when (= 2020 (ffirst results))
      (println (second (first results))))))