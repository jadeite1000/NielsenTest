FROM openjdk:17.0.1-jdk-slim as build

MAINTAINER jadeite1000.com

COPY target/NielsenTest-0.0.1-SNAPSHOT.jar NielsenTest-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/NielsenTest-0.0.1-SNAPSHOT.jar"]