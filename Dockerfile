# Compilar la aplicación usando Gradle con Java 17
FROM gradle:8.5-jdk17 AS build
WORKDIR /app
COPY . .
RUN ./gradlew build -x test

# Darle permisos de ejecución al wrapper de Gradle
RUN chmod +x gradlew
RUN ./gradlew build -x test

# Ejecutar la aplicación con la imagen oficial moderna de Java 17
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]