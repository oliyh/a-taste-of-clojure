(ns a-taste-of-clojure.core
  (:require [clojure.string :as string]
            [schema.core :as s]
            [schema.coerce :as sc]))

(s/defschema HouseTransaction
  {:baths     s/Int
   :beds      s/Int
   :sq__ft    s/Int
   :sale_date s/Str
   :type      s/Keyword
   :longitude s/Num
   :latitude  s/Num
   :state     s/Str
   :city      s/Str
   :street    s/Str
   :zip       s/Str
   :price     s/Int})

(defn load-data []
  (let [[header & rows] (string/split (slurp "resources/house-transactions.csv") #"\r")
        columns (map keyword (string/split header #","))
        coercer (sc/coercer HouseTransaction sc/string-coercion-matcher)]
    (->> rows
         (map (fn [row] (zipmap columns (string/split row #","))))
         (map coercer))))

(defn cheapest-bedrooms []
  (for [[beds transactions] (group-by :beds (load-data))
        :let [cheapest (first (sort-by :price transactions))]]
    [beds (:price cheapest)]))
