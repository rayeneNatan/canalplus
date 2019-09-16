# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
LABEL maintainer="rayene.bessrour@natan.fr"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 9899 available to the world outside this container
EXPOSE 9899

# The application's jar file
ARG JAR_FILE=target/canalplus-test-automation.jar

# Add the application's jar to the container
ADD ${JAR_FILE} canalplus-test-automation.jar

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "/canalplus-test-automation.jar"]