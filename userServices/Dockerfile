FROM maven:3.8.3-openjdk-17
EXPOSE 8080
WORKDIR /app
COPY ./ /app/
CMD mvn install
CMD mvn spring-boot:run