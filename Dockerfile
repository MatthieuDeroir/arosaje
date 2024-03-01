FROM openjdk:21
COPY target/*.jar arosaje.jar
ENTRYPOINT ["java","-jar","/arosaje.jar"]