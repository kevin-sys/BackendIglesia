# Configura la imagen base de Java
FROM adoptopenjdk:11-jdk-hotspot

# Copia el archivo JAR generado por Maven al contenedor
COPY target/Backend-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que se ejecuta tu aplicación Spring Boot
EXPOSE 8080

# Comando para ejecutar tu aplicación Spring Boot
CMD ["java", "-jar", "app.jar"]
