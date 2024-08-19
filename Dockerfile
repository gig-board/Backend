FROM gradle:7.6-jdk17 AS builder

WORKDIR /app

COPY . .

RUN ./gradlew clean build

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/app/app.jar"]