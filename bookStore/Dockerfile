FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN chmod +x mvnw

# Copy the source code directly
COPY src ./src

# Build the application jar (Maven will download needed dependencies automatically)
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/bookStore-0.0.1-SNAPSHOT.jar"]