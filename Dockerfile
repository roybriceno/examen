# Stage 1: Package .jar
FROM maven:3.6.3-openjdk-11 AS builder
WORKDIR /opt/app
COPY . .
RUN mvn clean package

# Stage 2: Extract Layers
FROM adoptopenjdk/openjdk11-openj9:debianslim-jre AS result
WORKDIR /package
COPY --from=builder /opt/app/target/example.jar .
RUN java -Djarmode=layertools -jar example.jar extract

# Stage 3: Layered Base Execution
FROM adoptopenjdk/openjdk11-openj9:debianslim-jre
WORKDIR /app
COPY --from=result package/dependencies/ ./
COPY --from=result package/snapshot-dependencies/ ./
COPY --from=result package/spring-boot-loader/ ./
COPY --from=result package/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]