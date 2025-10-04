# ------------------------------
# Stage 1: Build common-utils
# ------------------------------
FROM maven:3.9.9-eclipse-temurin-21 as common-utils-builder

WORKDIR /common-utils

# Copy common-utils files
COPY ../common-utils/pom.xml ./pom.xml
COPY ../common-utils/src ./src

# Build and install common-utils into local Maven repo
RUN mvn clean install -DskipTests

# ------------------------------
# Stage 2: Build order-service
# ------------------------------
FROM maven:3.9.9-eclipse-temurin-21 as order-service-builder

WORKDIR /app

# Copy product-service files
COPY ../order-service/pom.xml ./pom.xml
COPY ../order-service/src ./src

# Copy Maven local repo from previous stage to reuse common-utils
COPY --from=common-utils-builder /root/.m2 /root/.m2

# Download all dependencies offline
RUN mvn dependency:go-offline -B

# Package the product-service jar
RUN mvn clean package -DskipTests

# ------------------------------
# Stage 3: Run product-service
# ------------------------------
FROM openjdk:21-jdk as runner

WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=order-service-builder /app/target/order-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4000

ENTRYPOINT ["java", "-jar", "app.jar"]
