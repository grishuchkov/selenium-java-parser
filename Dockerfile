FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /
COPY /src /src
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline
RUN mvn -f /pom.xml clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /
COPY /src /src
COPY --from=build /target/*.jar application.jar
EXPOSE 8100
ENTRYPOINT ["java", "-jar", "application.jar"]