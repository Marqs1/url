FROM openjdk:21
WORKDIR /app
COPY target/shortener-write-service.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
