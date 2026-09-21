# Stage 1: Build stage using Maven and Java 17
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app

# Copy pom.xml and pre-fetch dependencies for efficient Docker layer caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build application artifact
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Lightweight Runtime stage
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Create a non-root system user for security best practices
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Copy compiled JAR from build stage
COPY --from=build /app/target/*.jar app.jar

# Default fallback PORT for local container runs (Render overrides $PORT at runtime)
ENV PORT=8080
EXPOSE 8080

# Execute Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
