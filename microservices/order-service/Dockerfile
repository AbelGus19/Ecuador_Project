FROM openjdk:17
WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests || true
CMD ["java", "-jar", "target/order-service-0.0.1-SNAPSHOT.jar"]
