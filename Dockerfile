FROM openjdk:8
ADD target/spring-boot-project.jar spring-boot-project.jar
EXPOSE 8080
ENTRYPOINT ["java" , "-jar" , "spring-boot-project.jar" ]
