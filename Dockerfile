# Use a Gradle image as the base for building the application
FROM gradle:8.8-jdk17 AS builder

# Set the working directory
WORKDIR /app

# Copy the Gradle wrapper and build files
COPY gradle gradle
COPY gradlew gradlew
COPY build.gradle settings.gradle ./

# Copy source files
COPY src src

# Build the application
RUN ./gradlew clean build --no-daemon -x test

# Use a lightweight JDK image for the final application image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the builder image
COPY --from=builder /app/build/libs/backend-0.0.1-SNAPSHOT.jar /app/backend-0.0.1-SNAPSHOT.jar

# Expose the application port
EXPOSE 9090

# Set the entry point for the application
ENTRYPOINT ["java", "-jar", "/app/backend-0.0.1-SNAPSHOT.jar"]