FROM maven:3.5-jdk-9-slim

WORKDIR      /appfile-api
ADD     .    /appfile-api

RUN mvn clean package -D "maven.test.skip=true"
RUN cp target/appfile-api-1.0-SNAPSHOT.jar /appfile-api/appfile-api-1.0.0.jar

CMD java -jar -Dserver.port=$PORT /appfile-api/appfile-api-1.0.0.jar

