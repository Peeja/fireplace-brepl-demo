(ns fireplace-brepl-demo.core
  (:require [cemerick.austin.repls :refer [browser-connected-repl-js]]
            [clojure.java.io :as io]
            [compojure.core :refer [GET defroutes]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [net.cgrand.enlive-html :as enlive]))

(defonce repl-env (reset! cemerick.austin.repls/browser-repl-env
                          (cemerick.austin/repl-env)))

(enlive/deftemplate index
  (io/resource "app.html")
  []
  [:body] (enlive/append
            (enlive/html [:script (browser-connected-repl-js)])))

(defroutes app-routes
  (GET "/" [] (index))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

