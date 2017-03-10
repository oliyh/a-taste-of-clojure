(defproject a-taste-of-clojure-demo "0.1.0-SNAPSHOT"
  :description "Demos for my talk entitled a-taste-of-clojure"
  :url "https://github.com/oliyh/a-taste-of-clojure"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :profiles {:dev {:exclusions [[org.clojure/tools.reader]]
                   :dependencies [[org.clojure/clojure "1.8.0"]
                                  [org.clojure/tools.reader "0.10.0"]
                                  [prismatic/schema "1.1.2"]]}})
