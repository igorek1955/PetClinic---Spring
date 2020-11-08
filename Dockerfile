FROM openjdk:11
ADD pet-clinic-web/target/pet-clinic-web-0.0.5-SNAPSHOT.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"]