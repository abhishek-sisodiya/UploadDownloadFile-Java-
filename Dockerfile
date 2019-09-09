# our base build image
FROM maven as maven

# copy the project files
COPY ./pom.xml ./pom.xml

# build all dependencies
RUN mvn dependency:go-offline -B

# copy your other files
COPY ./src ./src

# build for release
RUN mvn package

# our final base image
FROM openjdk:8-jre-alpine

# set deployment directory
WORKDIR /pivotBackend

# copy over the built artifact from the maven image
COPY --from=maven target/springboot-upload-download-file-rest-api-example-0.0.1-SNAPSHOT.jar ./

# set the startup command to run your binary
CMD ["java", "-jar", "./springboot-upload-download-file-rest-api-example-0.0.1-SNAPSHOT.jar"]