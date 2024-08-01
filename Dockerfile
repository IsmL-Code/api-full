# Usa una imagen base de OpenJDK para Spring Boot
FROM openjdk:17.0.1-jdk-slim


# Copia el archivo JAR de la aplicación al contenedor
COPY target/api-full-0.0.1-SNAPSHOT.jar   java-app.jar

# Comando para iniciar la aplicación, usando las variables de entorno
ENTRYPOINT ["java", "-jar", "java-app.jar"]



