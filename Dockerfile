FROM eclipse-temurin:25-jdk AS build
WORKDIR /app
RUN apt-get update && apt-get install -y maven
COPY . .
RUN mvn clean install -DskipTests

FROM eclipse-temurin:25-jdk
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 10000
ENTRYPOINT ["java", "-jar", "app.jar"]