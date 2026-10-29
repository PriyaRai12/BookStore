# Use official Eclipse Temurin JDK 17 as base image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper files first to leverage caching
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Give execution permission to mvnw
RUN chmod +x mvnw

# Download dependencies offline (prevents timeout issues)
RUN ./mvnw dependency:go-offline -B

# Copy the actual source code
COPY src ./src

# Build the application jar (skipping tests for faster cloud build)
RUN ./mvnw clean package -DskipTests

# Expose port 8080 for web traffic
EXPOSE 8080

# Run the generated jar file
CMD ["java", "-jar", "target/*.jar"]