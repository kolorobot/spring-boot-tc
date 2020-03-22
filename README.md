# Spring Boot tests with Testcontainers and PostgreSQL (or MySQL or MariaDB)

## Package the application

- Build package

`$ ./mvnw clean package -Dtest=OwnerRepositoryTests,OwnerResourceTests`

> To skip the tests use: `-DskipTests=true` 

- Extract fat-jar

`$ mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)`

## Run with `docker-compose`

`$ docker-compose build && docker-compose up`

## API

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