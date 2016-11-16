(ns gas-data-analytics.core)

(require '[clojure.java.io :refer [as-url]])
(require '[com.hypirion.clj-xchart :as c])

(defn -main []
	(def raw (slurp (as-url "http://10.0.0.240:8080")))
			(def cleaned_sequences (map (fn[x] (Integer/parseInt x)) (re-seq #"[1-9][0-9]*|0" raw)))
			(prn (take 10 cleaned_sequences))

(defstruct xyp :x :y :stroke)			


			(def chart 
				(c/xy-chart {"gas Concentration fluctuations" 
					[(drop 100 cleaned_sequences) (take 100 cleaned_sequences) ]}))
			
			(c/view chart)
			)