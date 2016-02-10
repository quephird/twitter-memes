(ns twitter-memes.core
  (:require [ring.adapter.jetty :as a]
            [twitter-memes.handler :as h]))

(defn -main []
  (let [port (Integer/parseInt (get (System/getenv) "PORT" "8080"))]
    (a/run-jetty h/app {:port port})))