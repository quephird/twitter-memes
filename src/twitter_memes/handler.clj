(ns twitter-memes.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as h]
            [ring.middleware.json :as j]
            [ring.util.response :as u]
            [compojure.route :as r]
            [twitter-memes.throw-off-roof :as t]))

(defn throw-response [object]
  (let [body (t/throw-object-text object)]
    (-> body
      u/response
      (u/content-type "text/plain")
      (u/charset "UTF-8"))))

(defroutes app-routes
  (GET "/" [] "I'm alive!")
  (context "/throw" [] 
    (defroutes throw-routes
      (context "/:object" [object]
        (defroutes object-routes
          (GET "/" [] (throw-response object))))))
  (r/not-found "Not Found"))

(def app
  (-> (h/api app-routes)
    (j/wrap-json-body)
    (j/wrap-json-response)))
