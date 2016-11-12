(ns gas-data-analytics.core)

(require '[clojure.java.io :refer [as-url]])

(defn -main []
	(def raw (slurp (as-url "http://10.0.0.240:8080")))
			(prn (nth (take 10 (re-seq #"[1-9][0-9]*|0" raw)) 1)
			))