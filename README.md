# PetClinicSpring
[![CircleCI](https://circleci.com/gh/igorek1955/pet-clinic-springboot.svg?style=svg&circle-token=60723d6ee9c5b2c188dc42a47f21a8e4a78bcbcd)](https://app.circleci.com/settings/project/github/igorek1955/pet-clinic-springboot)

Reimagined version of original PetClinic project.
This version supports:
- built-in map-based data storage
- h2-based data storage
- SQL-based data storage

To select storage method refer to application.properties in pet-clinic-web module
```
#profile
spring.profiles.active=map
```

If you choose to select SQL based data storage , uncomment this section and input your parameters.

```
#postgres database config
spring.jpa.generate-ddl=true
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.datasource.platform=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/petclinic
spring.datasource.username=
spring.datasource.password=
```

To run PetClinic from command line, run these commands: 
```
git clone https://github.com/igorek1955/pet-clinic-springboot.git
cd pet-clinic-springboot/
./mwnw install 
cd pet-clinic-web
./mwnw spring-boot:run
```

To deploy application via Docker refer to the Dockerfile and configure it to your liking.

```
FROM openjdk:11
ADD target/pet-clinic-web-0.0.5-SNAPSHOT.jar app.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app.jar"]
```
To create and deploy image run these commands in the command line:
```
docker build -f Dockerfile -t petclinic .
docker run -p 8080:8080 -d petclinic
```

# My Other Projects

| Project | Link |
|------|-------|
| Recipe App build with Spring Boot on MongoDB | [github](https://github.com/igorek1955/recipeapp-spring-mongoDB) |
| Recipe App build with Spring Boot on MySQL |[github](https://github.com/igorek1955/recipeapp-spring-mysql) |
| Miscellaneous projects build with Java  | [github](https://github.com/igorek1955/little-projects) |