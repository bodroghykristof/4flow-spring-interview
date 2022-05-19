# Practical exercise

We are interested in some attributes of cities from all around the world. So we would like to implement a new endpoint, where we can query cities by a specific
id. Cities are originally available via an open API (GeoDB Cities). But as long as our license does not allow unlimited access, we would like to cache those
responses, so we won't call the API unless it is necessary. In this certain case, cache means that we save the interesting data into our H2 database (CITY
table) and serve the request from there if possible.

# Requirements

* There is a new endpoint on http://localhost:8080/city/wikiDataId/ and it also accepts a [wikiDataId](https://www.wikidata.org/wiki/Wikidata:Identifiers)
  parameter as path variable (skeleton has already been implemented)
* Our service (CityService) checks if we already have this city in our database
* If yes, returns it as a CityOutboundDTO json response with HTTP 200 as status code
* If not, calls the external API (use CityService.getCityByWikiDataId()), saves the returned city (response object is a GeoDbResponse) and
  returns it as a CityOutboundDTO json response with HTTP 200 as status code
* Implement another endpoint, which accepts a city name and queries our database
* If there is a city with that name, return it as a CityOutboundDTO json response with HTTP 200 as status code
* If there isn't a city with that name, return a proper HTTP response
* There are certain mappings which are needed: GeoDbResponse to City, City to CityOutboundDTO, please implement them as well
* Implement error handling: there might be some customer data or server errors, handle some of them with meaningful error messages and HTTP response codes

### How to use the service

* Start your preferred IDE (we favour IntelliJ for Java development)
* Build the maven project with ./mvnw clean install (run from this project root)
* Start the SpringInterviewApplication as a spring application from your IDE
* Spring profile does not matter, you can leave it on default
* H2 database starts up automatically in-memory, its details can be found in the application.properties file
* CITY table has already been added to the database (see schema.sql) and the corresponding entity (City) also exists
* H2 database can be reached via http://localhost:8080/h2-console/, to be able to login sucessfully, use the corresponding data from application.properties

### Examples

* Example wikiDataIds with city names can be found in example_cities.txt
