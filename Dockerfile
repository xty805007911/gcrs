FROM openjdk:8-jdk-alpine
VOLUME /tmp

ADD gcrs-api-1.0-SNAPSHOT.jar /app.jar

EXPOSE 80

ENV JAVA_OPTS=""

ENTRYPOINT java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar
