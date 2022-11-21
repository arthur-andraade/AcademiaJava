FROM eclipse-temurin:11-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} api-pessoa.jar
ENTRYPOINT ["java","-jar","/api-pessoa.jar"]