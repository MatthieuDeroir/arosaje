FROM openjdk:21
COPY target/arosaje-0.0.1-SNAPSHOT.jar arosaje.jar
ENTRYPOINT ["java","-jar","/arosaje.jar"]