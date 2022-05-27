FROM openjdk:8
ADD target/docker-department.jar docker-department.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar",docker-department.jar"]
