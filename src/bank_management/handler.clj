(ns bank-management.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [bank-management.db :as db]
            [muuntaja.middleware :as middleware]
            [muuntaja.core :as m]
            [ring.util.response :as response]))

(def m-instance (m/create))

(defroutes app-routes
           (GET "/bancos" [] (response/response (db/listar-bancos)))

           (GET "/bancos/:codigo" [codigo]
             (let [codigo (Integer/parseInt codigo)
                   banco (db/buscar-banco codigo)]
               (if banco
                 (response/response banco)
                 (response/status (response/response {:erro "Não encontrado"}) 404))))

           (POST "/bancos" {body :body}
             (let [banco (db/criar-banco body)]
               (response/status (response/response banco) 201)))

           (PUT "/bancos/:codigo" [codigo :as {body :body}]
             (let [codigo (Integer/parseInt codigo)]
               (db/atualizar-banco codigo body)
               (response/response {:mensagem "Atualizado"})))

           (DELETE "/bancos/:codigo" [codigo]
             (let [codigo (Integer/parseInt codigo)]
               (db/deletar-banco codigo)
               (response/response {:mensagem "Deletado"})))

           (route/not-found "Recurso não encontrado"))

(def app
  (-> app-routes
      (middleware/wrap-format m-instance)))
