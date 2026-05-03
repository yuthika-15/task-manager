FROM eclipse-temurin:17
WORKDIR /app
COPY . .
RUN ./mvnw clean package
CMD ["java", "-jar", "target/*.jar"]