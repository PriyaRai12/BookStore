FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline -B

COPY src ./src

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

# Yahan path ko exact bookStore-0.0.1-SNAPSHOT.jar kar dein:
CMD ["java", "-jar", "target/bookStore-0.0.1-SNAPSHOT.jar"]