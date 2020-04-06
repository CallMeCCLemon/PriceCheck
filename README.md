# PriceCheck
Java Service to vend pricing data from a Dynamo DB table.



## Getting Started
The public facing API for this code base is generated using gRPC's plugin for Gradle. In order to get the nice 
auto-complete functionality of IntelliJ, you will need to build using Gradle first. To do this, choose 
"Edit Configuration" and choose the Gradle project "PriceCheck" and provide the task "build" then click run. This will
pull all of the dependencies of the project into your workspace and generate the API Java code from the .proto files
which define the API.

### Unit testing
This project is currently configured to execute any JUnit and Spock unit tests. The Spock unit testing framework is 
quite nice to use (compared to JUnit), althought the trade-off is a developer has to write the tests in Groovy. Valid 
Java code will succeed to compile, but does not take advantage of the syntax sugar which Groovy offers along with the 
flexibility of mocking and stubbing.

To run the tests, you can either use IntelliJ or Gradle directly. I (@CallMeCCLemon) would recommend using IntelliJ IDEA 
as your runtime as it gives a number of useful printed messages along with being able to quickly find which tests
passed/failed along with knowing what the output of each failed test was. 

Go to "Settings > Build, Execution, Deployment > Build Tools > Gradle" and you'll find a "Run Tests Using" dropdown. 
Select "IntelliJ IDEA" and you're all set. 