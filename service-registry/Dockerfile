FROM openjdk:17-alpine
EXPOSE 8761
ADD target/service-registry-0.0.1-SNAPSHOT.jar Serviceregistry.jar
ENTRYPOINT ["java","-jar","/Serviceregistry.jar"]