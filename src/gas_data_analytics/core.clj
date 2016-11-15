(ns gas-data-analytics.core
(:require [clojure.java.io :refer [as-url]])
(:require [ring.adapter.jetty :refer [run-jetty]]))

(defn -main []
(def raw (slurp (as-url "http://10.0.0.240:8080")))
			(def cleaned_sequences (map (fn[x] (Integer/parseInt x)) (re-seq #"[1-9][0-9]*|0" raw)))
			(def readings (take 10 cleaned_sequences))
			
(defn handler "request -> response"
	[req]
	{:status 200
	:headers {"Content-Type" "text/plain; charset=UTF-8"}
	:body readings})

(defonce server
	(run-jetty handler {:port 3000
		:join? false}))
)