FROM maven:3.5-jdk-8-alpine

WORKDIR      /server
ADD     .    /server

RUN mvn clean package -D "maven.test.skip=true"
RUN cp target/appfile-api-1.0-SNAPSHOT.jar /server/appfile-api-1.0.0.jar
CMD java -jar -Dserver.port=8080 /server/appfile-api-1.0.0.jar