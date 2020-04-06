# PriceCheck
Java Service to vend pricing data from a Dynamo DB table.



## Getting Started
The public facing API for this code base is generated using gRPC's plugin for Gradle. In order to get the nice 
auto-complete functionality of IntelliJ, you will need to build using Gradle first. To do this, choose 
"Edit Configuration" and choose the Gradle project "PriceCheck" and provide the task "build" then click run. This will
pull all of the dependencies of the project into your workspace and generate the API Java code from the .proto files
which define the API.