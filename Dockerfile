FROM maven:3.9.6-sapmachine-17 AS builder

WORKDIR /build

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src

# Pula os testes
RUN mvn package -DskipTests

FROM openjdk:17-jre-slim

WORKDIR /app

COPY --from=builder /build/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]