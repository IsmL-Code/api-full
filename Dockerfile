# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-alpine

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copia el JAR de tu aplicación al contenedor
COPY target/api-full-0.0.1-SNAPSHOT.jar /app/api-full.jar

# Expone el puerto que tu aplicación usa
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/api-full.jar"]




