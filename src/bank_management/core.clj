(ns bank-management.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [bank-management.handler :refer [app]])
  (:gen-class))

(defn -main [& args]
  (run-jetty app {:port 3000 :join? false}))