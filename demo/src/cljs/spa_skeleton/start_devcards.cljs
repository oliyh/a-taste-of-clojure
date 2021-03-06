(ns spa-skeleton.start-devcards
  (:require [cljs.test :refer-macros [testing is]]
            [clojure.string :as str]
            [spa-skeleton.app :as app]
            [devcards.core :as dc :refer-macros [defcard deftest defcard-rg start-devcard-ui!]]))

(enable-console-print!)


(defcard-rg card-test
  [:div.mdl-grid
   [:div.mdl-cell.mdl-cell--6-col
    [app/card "Good evening, ladies and gentlemen" "English (formal)"]]

   [:div.mdl-cell.mdl-cell--6-col
    [app/card "Hola" "Spanish" [:button.mdl-button "Learn more"]]]

   [:div.mdl-cell.mdl-cell--6-col
    [app/card "Ciao"
     [:div
      [:p "Italian"]
      [:p "protip: authentic Italian greetings include flamboyant hand gestures, hugging and kissing"]]]]

   [:div.mdl-cell.mdl-cell--6-col
    [app/card "Bonjour" "French"]]])

(start-devcard-ui!)
