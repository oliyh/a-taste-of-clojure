(ns houses.transactions
  (:require [clojure.string :as string]
            [schema.core :as s]
            [schema.coerce :as sc]))

(def ^:private transactions-file "resources/house-transactions.csv")

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























#_(defn load-data []
  (let [[header & rows] (string/split (slurp transactions-file) #"\r")
        ks (map keyword (string/split header #","))
        coercer (sc/coercer HouseTransaction sc/string-coercion-matcher)]
    (->> rows
         (map #(string/split % #","))
         (map #(zipmap ks %))
         (map coercer))))


#_(defn cheapest-bedrooms []
  (for [[bedrooms properties] (group-by :beds (load-data))
        :let [cheapest (first (sort-by :price properties))]]
    [bedrooms (:price cheapest)]))
