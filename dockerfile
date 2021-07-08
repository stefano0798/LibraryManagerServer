FROM openjdk:11
ADD build/libs/web_services-0.0.1-SNAPSHOT.jar lib_image.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","lib_image.jar"]