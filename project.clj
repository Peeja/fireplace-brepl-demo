(defproject fireplace-brepl-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"

  :min-lein-version "2.0.0"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [hiccup "1.0.5"]
                 [enlive "1.1.5"]
                 [org.clojure/clojurescript "0.0-2311"]]

  :plugins [[lein-pdo "0.1.1"]
            [lein-ring "0.8.11"]
            [lein-cljsbuild "1.0.3"]]

  :ring {:handler fireplace-brepl-demo.core/app
         :port    7777
         :nrepl   {:start? true}}

  :source-paths ["src/clj" "src/cljs"]
  :resource-paths ["resources"]

  :cljsbuild {
    :builds [{:source-paths ["src/cljs"]
              :compiler {
                :output-to "resources/public/js/main.js"
                :output-dir "resources/public/js/out"
                :optimizations :none
                :source-map true}}]}

  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]]
                   :plugins [[com.cemerick/austin "0.1.5"]]
                   :aliases {"go" ["pdo" "cljsbuild" "auto," "ring" "server-headless"]}}})

