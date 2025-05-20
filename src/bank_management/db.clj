(ns bank-management.db
  (:require [next.jdbc :as jdbc]
            [next.jdbc.sql :as sql]))

(def db-spec
  {:dbtype "postgresql"
   :dbname "finance"
   :host "localhost"
   :user "usuario"
   :password "1234"})


(def datasource (jdbc/get-datasource db-spec))

(defn listar-bancos []
  (sql/query datasource ["SELECT * FROM banco"]))

(defn buscar-banco [codigo]
  (jdbc/execute-one! datasource
                     ["SELECT * FROM banco WHERE codigo = ?" codigo]))


(defn criar-banco [dados]
  (sql/insert! datasource :banco dados))

(defn atualizar-banco [codigo dados]
  (sql/update! datasource :banco dados {:codigo codigo}))

(defn deletar-banco [codigo]
  (sql/delete! datasource :banco {:codigo codigo}))
