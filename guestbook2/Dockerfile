# Step 1: Use an official Java runtime image
FROM eclipse-temurin:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the JAR file into the container
COPY build/libs/guestbook2-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the port your Spring Boot app will run on
EXPOSE 8080

# Step 5: Define the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
