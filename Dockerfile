# FROM openjdk:8

# COPY ./target/demo-0.0.1-SNAPSHOT.jar /usr/app/

# WORKDIR /usr/app

# CMD ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]

# EXPOSE 8092


FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/demo-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar
EXPOSE 8092
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]