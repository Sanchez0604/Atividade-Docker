FROM maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app


COPY pom.xml .

ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8
RUN mvn dependency:go-offline -B


COPY src ./src
RUN mvn package -DskipTests


FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copia o JAR da etapa de build
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
