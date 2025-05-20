FROM clojure:openjdk-17-lein AS builder

WORKDIR /app

COPY . .

RUN lein deps
RUN lein uberjar

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/bank-management-0.1.0-SNAPSHOT-standalone.jar ./app.jar

EXPOSE 3000

CMD ["java", "-jar", "app.jar"]
