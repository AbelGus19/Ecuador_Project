FROM openjdk:17
COPY . /app
WORKDIR /app
RUN ./mvnw clean package
CMD ["java", "-jar", "target/product-service-0.0.1-SNAPSHOT.jar"]