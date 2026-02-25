From maven:3.9.6-ecllipse-temurin-17
WORKDIR /app

COPY . .

RUN mvn clean package-DskipTests

EXPOSE 8080
CMD["java" , "jar" ,"target/ExpenseTracker-0.0.1-SNAPSHOT.jar"]

