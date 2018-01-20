# A stand-alone GullySports Application consists of various REST-APIs.

# Pre-requisite 

1. Eclipse (latest available)
2. Install [Spring Tools ](https://marketplace.eclipse.org/content/spring-tools-aka-spring-ide-and-spring-tool-suite)
3. Java 8 Runtime
4. Mongo DB

# Instructions

1. Create a user in MongoDB, use the code available in scripts/createMongoUser.sh
2. Configure the MongoDB credentials in config/application.properties appropriately if you want to change it.
3. Setup the environment using setenv.sh or setenv.bat depending on the platform. i.e. $. ./setenv.sh or CMD>setenv.bat
3. Build and run the code(use build.bat or build.sh scripts folder depending on the platform), the build script would do the following.
    * Check the code for style errors and executes unit tests

        ./gradlew check
 

    * Execute unit tests
       ./gradlew runUnitTests
    * Build and Run the code

        ./gradlew bootRun

4. A sample REST API will be exposed on http://localhost:8080/dbentity and can be invoked as follows
        http://localhost:8080/dbentity/show?name=LaserJet
   
        Will return laserJet properties
        
5. Swagger UI URL: http://localhost:8080/swagger-ui.html

6. Swagger UI docs: http://localhost:8080/v2/api-docs
   
7. By default project supports gradle builds, in case you want to use Maven for builds you can generate a POM.xml as follows

        ./gradlew writeNewPom

8. A sample integration test is included in the project to demonstrate how to use a 3rd party REST api, as an example the API
exposed by the sample project is excersized. In order to run the integration tests do the following

	$./gradlew bootRun 

	open another window

	$./gradlew integrationTests
	
# Create jar and run the service

Run below commands to create the jar and start the service -
1. ./gradlew build
2. java -jar build\libs\cartos_pricing_service-0.1.0.jar

9. Creating the distribution, this command will create a dist folder containing the jar, version.txt and start.sh startup script
	$./gradlew -x test build

# Eclipse

1. Update the eclispe project based on the build.gradle run following command

        ./gradlew eclipse

2. Import the project in Eclipse as an existing project.

#Details
1. The project is based on Spring framework and uses Spring Boot to bootstrap the system.
2. The project has sample unit tests for all layers, i.e repository, service as well as controller
3. The coverage report is generated and placed in  build/reports/jacoco/html
4. The checkstyle report is placed in build/reports/checkstyle
5. The unit tests report is placed in build/reports/tests

Note: for unit tests embedded mongoDB is used and the database is created in mongo_embedded folder




