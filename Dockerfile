FROM maven:3.8.1-jdk-8 as builder

WORKDIR /app

COPY . /app

RUN mvn clean package

FROM openjdk:8-jre

COPY --from=builder /app/target/*.jar ./app.jar

EXPOSE 8080

CMD ["java","-jar","app.jar"]

