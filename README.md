# # Rest Web Service TEST WEB Intellisense
This projects shows the basic configuration needed to start a Rest web service. 
## Install
```sh
mvn clean install
mvn install
````
or IDE
```sh 
 right-click on test>maven>update project 

right-click on test>Run as>Maven Install
````
### Run WS
```sh 
right-click on test>Run as >springBoot App 
````
## Docker usage
Build the project and the Docker image with
```
mvn clean install
```
Then run the container exposing port 8080
```
docker run -it -p 8080:8080 intellisense:0.0.1-SNAPSHOT
```
### HTTP methods and actions
 
 you need to identify what actions you want to use according to the instructions of the test
 
  * POST http://localhost:8080/period - establish a period for recovering asset measurements by time intervals, use the body to send period data in JSON format 

## Swagger API (API documentation)
ui
```sh
- http://localhost:8080/swagger-ui.html#
````
JSONFormat
```sh
- http://localhost:8080/v2/api-docs
````
## Example Request POST 
### POST (Manufacturers)                                                                                                                 
	http://localhost:8080/period
 #### Requests
     {
        "period": 180
    }
   
  #### answers
  
  {
  "_3000": [
    4.281562622024757
  ],
  "_3001": [
    44.98254289595115
  ],
  "_3002": [
    1.8655643924188694
  ],
  "_3003": [
    47.99150043315151
  ],
  "_3004": [
    8.126861049772506
  ],
  "_3005": [
    44.07532116749148
  ],
  "time": null
}
   
