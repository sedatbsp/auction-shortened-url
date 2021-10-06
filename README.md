# Auction Shortened URL Service

**For example:**<br>
- Original link : https://www.linkedin.com/in/sedatbaspinar/  <br>
- Shortened url : https://shortenedurl-sedatbsp.herokuapp.com/6be3b63c

All URLs can be checked at https://shortenedurl-sedatbsp.herokuapp.com/api/getAllUrls


### Prerequisites
- [Java](https://dev.java/learn/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/docs/)
- [Lombok](https://projectlombok.org/setup/maven)

### Tools
- IntelliJ IDEA or any preferred IDE
- Postman (or any RESTful API testing tool)

### Run the Application

Clone the source codes into your local system.

```
git clone https://github.com/sedatbsp/auction-shortened-url
```

Then, to run the application, run the following command in a terminal window (in the ``` complete ```) directory:

```
mvn spring-boot:run
```

>  it will run application as spring boot application

or
> run main method from `AuctionShortenedUrlApplication.java` as spring boot application.


## API Endpoints

Endpoints running at https://shortenedurl-sedatbsp.herokuapp.com

<small>
You can test endpoints using the Postman RESTful API testing tool.
</small>

### Sign Up

````
POST /api/authentication/sign-up HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "name":"Sedat Başpınar",
    "username":"sedatbsp",
    "password":"heeeeyyo!"
}
````

### Sign In

```` 
POST /api/authentication/sign-in HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "username":"sedatbsp",
    "password":"heeeeyyo!"
}
````

### Make Admin

````
PUT /api/internal/make-admin/sedatbsp HTTP/1.1
Host: localhost:8080
Authorization: Bearer InternalApiKey123!
````

### Generate Shortened Url

````
POST /api/generate HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzZWRhdGJzcCIsInJvbGVzIjoiUk9MRV9VU0VSIiwidXNlcklkIjozLCJleHAiOjE2MzM1NDMzOTl9.3XP-8S6bCpvlrBxdbR0a_zhFINJ3eVhaFO9rd0cuGGC81K3jeWF_KgFkXKPK0DuWrtBZfCBboFSPN_NLpoRoDw
Content-Type: application/json

{
    "url":"https://stackoverflow.com/jobs"
}
````
- For example, **localhost:8080/0e502f9b** created. <br>This URL will redirect to the original link. (expiration date 6 months)
<br>
  
- Default expiration date can be set from the related method.

**expiration date** --- *optional*
````
POST /api/generate HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzZWRhdGJzcCIsInJvbGVzIjoiUk9MRV9VU0VSIiwidXNlcklkIjozLCJleHAiOjE2MzM1NDMzOTl9.3XP-8S6bCpvlrBxdbR0a_zhFINJ3eVhaFO9rd0cuGGC81K3jeWF_KgFkXKPK0DuWrtBZfCBboFSPN_NLpoRoDw
Content-Type: application/json

{
    "url":"https://spring.io/microservices",
    "expirationDate":"2024-04-05T21:14:41.6477732"
}
````

### Shortened URL

````
GET /36f4ac18 HTTP/1.1
Host: localhost:8080
````

*When the request is made, it will redirect to https://spring.io/microservices.*

### Get All Urls

````
GET /api/getAllUrls HTTP/1.1
Host: localhost:8080
````

### Delete Url

````
DELETE /api/delete/1f213cb3 HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzZWRhdGJzcCIsInJvbGVzIjoiUk9MRV9VU0VSIiwidXNlcklkIjozLCJleHAiOjE2MzM1NDMzOTl9.3XP-8S6bCpvlrBxdbR0a_zhFINJ3eVhaFO9rd0cuGGC81K3jeWF_KgFkXKPK0DuWrtBZfCBboFSPN_NLpoRoDw
````

<br>
<hr>