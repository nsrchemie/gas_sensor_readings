(ns gas-data-analytics.core)

(require '[clojure.java.io :refer [as-url]])

(defn -main []
	(def raw (slurp (as-url "http://10.0.0.240:8080")))
			(def cleaned_sequences (map (fn[x] (Integer/parseInt x)) (re-seq #"[1-9][0-9]*|0" raw)))
			; (prn (take 10 cleaned_sequences))

(defstruct xyp :x :y :stroke)
(doseq [[time sensor] ((fn[x] (map vector (range) x)) (take 10 cleaned_sequences))] (println (struct xyp time sensor "a")))

			)