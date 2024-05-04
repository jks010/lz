FROM openjdk:17-jdk-slim AS build

WORKDIR /app

COPY pom.xml mvnw ./

COPY .mvn .mvn

RUN ./mvnw -B dependency:go-offline

COPY src src

RUN ./mvnw -B clean package -DskipTests

FROM openjdk:17-jdk-slim

COPY --from=build /app/target/*.jar ./app.jar

EXPOSE 8080

#ENTRYPOINT ["tail", "-f", "/dev/null"]

CMD ["java", "-jar", "app.jar"]


