FROM openjdk:21
WORKDIR /app
COPY target/shortener-read-service.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
