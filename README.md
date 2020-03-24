# Spring Boot tests with Testcontainers and PostgreSQL

## References

- [Docker Compose for Spring Boot application with PostgreSQL](https://blog.codeleak.pl/2020/03/spring-boot-docker-compose.html)

## Package the application

- Package the application

`$ ./mvnw clean package`

> To skip the tests use: `-DskipTests=true` 

- Extract libraries from `fat-jar`

`$ mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)`

## Run

`$ docker-compose build && docker-compose up`

## Verify the application is running

> Application listens on port 9000.

```
$ http get :9000/owners

HTTP/1.1 200
Connection: keep-alive

{
    "_embedded": {
        "owners": []
    },
    "_links": {
        "profile": {
            "href": "http://localhost:8080/profile/owners"
        },
        "self": {
            "href": "http://localhost:8080/owners{?page,size,sort}",
            "templated": true
        }
    },
    "page": {
        "number": 0,
        "size": 20,
        "totalElements": 0,
        "totalPages": 0
    }
}
```