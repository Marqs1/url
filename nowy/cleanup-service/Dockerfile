FROM openjdk:21
WORKDIR /app
COPY target/cleanup-service.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
