(defproject bank-management "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring "1.11.0"]
                 [compojure "1.7.1"]
                 [metosin/muuntaja "0.6.10"] ;; JSON encoding/decoding
                 [com.zaxxer/HikariCP "5.1.0"]
                 [seancorfield/next.jdbc "1.2.659"]
                 [org.postgresql/postgresql "42.7.3"]]
  :repl-options {:init-ns bank-management.core}
  :main bank-management.core)

;; compojure (roteamento HTTP)
;; ring (servidor HTTP)
;; next.jdbc (acesso a banco de dados)
;; hikari-cp (pool de conexões)
;; Banco de dados: PostgreSQL


