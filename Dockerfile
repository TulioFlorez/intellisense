FROM openjdk:8-jre-alpine
WORKDIR /opt/intellisense
ARG JAR_FILE
COPY ${JAR_FILE} /opt/intellisense/intellisense.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","intellisense.jar"]