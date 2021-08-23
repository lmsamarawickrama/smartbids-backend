FROM openjdk:8-jdk-alpine
MAINTAINER saliam.com
COPY target/smartbids-0.0.1-SNAPSHOT.jar smartbids-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/smartbids-0.0.1-SNAPSHOT.jar"]