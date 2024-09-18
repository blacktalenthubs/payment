FROM gradle:7.5.1-jdk17 AS builder

WORKDIR /app

COPY . .

RUN gradle clean build -x test

FROM eclipse-temurin:17-jdk


WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
