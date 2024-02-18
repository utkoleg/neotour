FROM openjdk:23-slim-bullseye
ARG JAR_FILE=target/*.jar
COPY ./target/neotour-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]