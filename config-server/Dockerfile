FROM openjdk:17-alpine
EXPOSE 8082
ADD target/config-server-0.0.1-SNAPSHOT.jar Configserver.jar
ENTRYPOINT ["java","-jar","/Configserver.jar"]