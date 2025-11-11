# ---- Stage 1: Build ----
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# 🟢 1. Changed paths to be consistent with build context
COPY ./configserver/pom.xml ./pom.xml
COPY ./configserver/src ./src

# 🟢 2. Simplified build — no separate go-offline step
RUN mvn clean package -DskipTests

# ---- Stage 2: Run ----
FROM openjdk:21-jdk

WORKDIR /app

# 🟢 3. Copy the built JAR
COPY --from=builder /app/target/configserver-0.0.1-SNAPSHOT.jar ./app.jar

# 🟢 4. NEW: Copy your YAML config files explicitly into the image
COPY ./configserver/src/main/resources/config ./config

# 🟢 5. Changed exposed port from 4003 → 8888 (Config Server default)
EXPOSE 8888

# 🟢 6. Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
