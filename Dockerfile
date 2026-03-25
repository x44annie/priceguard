# BUILD STAGE
FROM gradle:9.1.0-jdk25-alpine AS builder
WORKDIR /app

COPY gradlew ./
COPY gradle gradle
COPY build.gradle settings.gradle ./
RUN ./gradlew dependencies || true

COPY src src
RUN ./gradlew bootJar -x test

# RUNTIME STAGE
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]