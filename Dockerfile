# Compilar la aplicación usando Gradle con Java 17
FROM gradle:8.5-jdk17 AS build
WORKDIR /app
COPY . .

# Primero damos los permisos (¡Debe ir aquí arriba!)
RUN chmod +x gradlew

# Luego compilamos
RUN ./gradlew build -x test

# Ejecutar la aplicación con la imagen oficial moderna de Java 17
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]