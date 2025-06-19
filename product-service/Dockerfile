# Use official OpenJDK 17 runtime image as base
FROM openjdk:17-jdk-slim

# Add a volume pointing to /tmp (optional, for Spring Boot temp files)
VOLUME /tmp

# Copy the built jar file into the container at /app.jar
COPY target/*.jar app.jar

# Expose the port your service runs on (adjust as needed)
EXPOSE 8081

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]
