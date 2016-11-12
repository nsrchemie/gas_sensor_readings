(ns gas-data-analytics.core)

(require '[clojure.java.io :refer [as-url]])

(defn -main []
	(prn (slurp (as-url "http://10.0.0.240:8080"))))
