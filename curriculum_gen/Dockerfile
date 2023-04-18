# Use an official OpenJDK base image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /app
ENV STATIC_FILES_PATH /app/static
RUN mkdir -p $STATIC_FILES_PATH
# Copy the .jar file into the container
COPY ./src/main/static $STATIC_FILES_PATH
RUN ls -l $STATIC_FILES_PATH
COPY ./target/scala-3.2.2/Curriculum_Generator-assembly-0.1.0-SNAPSHOT.jar /app/Curriculum_Generator.jar
EXPOSE 8080

# Define the ENTRYPOINT to run the .jar file with the specified argument
ENTRYPOINT ["java", "-jar", "/app/Curriculum_Generator.jar", "server"]
