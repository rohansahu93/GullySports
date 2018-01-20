# A stand-alone GullySports Application consists of various REST-APIs.

The project is based on Spring framework and uses Spring Boot to bootstrap the system.

# Pre-requisite 

1. Eclipse (latest available)
2. Install [Spring Tools ](https://marketplace.eclipse.org/content/spring-tools-aka-spring-ide-and-spring-tool-suite)
3. Java 8 Runtime
4. Mongo DB

# Instructions

1. Create a user in MongoDB, use the code available in scripts/createMongoUser.sh
2. Configure the MongoDB credentials in config/application.properties appropriately if you want to change it.
3. Setup the environment using setenv.sh or setenv.bat depending on the platform. i.e. $. ./setenv.sh or CMD>setenv.bat
        
4. Swagger UI URL: https://localhost:8001/swagger-ui.html

5. Swagger UI docs: https://localhost:8001/v2/api-docs
   
6. By default project supports gradle builds, in case you want to use Maven for builds you can generate a POM.xml as follows

        ./gradlew writeNewPom
	
# Create jar and run the service

Run below commands to create the jar and start the service -
1. ./gradlew build
2. java -jar build\libs\cartos_pricing_service-0.1.0.jar

# Eclipse

1. Update the eclispe project based on the build.gradle run following command

        ./gradlew eclipse

2. Import the project in Eclipse as an existing project.
