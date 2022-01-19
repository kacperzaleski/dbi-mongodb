FROM openjdk:17-alpine
EXPOSE 8081
ADD target/albumrating-service-0.0.1-SNAPSHOT.jar AlbumratingService.jar
ENTRYPOINT ["java","-jar","/AlbumratingService.jar"]