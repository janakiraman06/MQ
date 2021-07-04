FROM openjdk:16-jdk-alpine
EXPOSE 8080
ENV BROKER_URL=tcp://192.168.0.9:61616
COPY pom.xml /logs/pom.xml
ARG JAR_FILE=target/demo1-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
