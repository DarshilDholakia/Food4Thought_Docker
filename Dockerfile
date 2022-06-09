FROM openjdk:17
LABEL maintainer="darshil"
COPY target/Food4Thought-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]