(ns spa-skeleton.server
  (:gen-class) ; for -main method in uberjar
  (:require [io.pedestal.http :as bootstrap]
            [spa-skeleton
             [service :as service]
             [config :refer [config]]]))

(defonce service-instance nil)

(defn create-server
  "Standalone dev/prod mode."
  ([] (create-server {}))
  ([{:keys [pedestal-opts]}]
   (alter-var-root #'service-instance
                   (constantly (bootstrap/create-server
                                (-> (merge service/service
                                           {::bootstrap/port (get-in (config) [:http :port])}
                                           pedestal-opts)
                                    (bootstrap/default-interceptors)))))))

(defn -main [& args]
  (create-server)
  (bootstrap/start service-instance))
