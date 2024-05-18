# WareHouse

This repo contains the basic web app for warehouse

## Getting Started
These instructions will get you a copy of the project.

### Prerequisites
- Java JDK 8 or 11
- Maven 3.3.1
- Lombok 1.18.32
- Jackson 2.16.0
- Jakarta 9.10
- Postgresql 42.3.6
- Jersey server 3.0.3
- JUnit 4.13.2
- Mockito 4
- Jakarta Servlet 5
- Jetty 11.0.9

### Running And Building
To build the project go to its directory, and run in terminal:
```sh
mvn clean install
```

To test the endpoints type this in terminal after the build:
```sh
mvn jetty:run
#and it will run on localhost:8080
```

2. **Then you can go to postman to test save and get endpoints:**

- GET: http://localhost:8080/api/goods/getAll
- POST: http://localhost:8080/api/goods/save (in body choose raw and json format then type the good information like this: 
```json
{
    "name": "",
    "quantity": 0
}
```
)
**And note that when sending the post response the content-type in header must be: application/json;charset=utf-8**

Also you can use curl for testing endpoints, like this:

- For post: 
```curl
curl --location 'http://localhost:8080/api/goods/save' \
--header 'Content-Type: application/json;charset=utf-8' \
--data '{
    "name": "new",
    "quantity": 10
}'
```
- For get:
```curl
curl --location --request GET 'http://localhost:8080/api/goods/getAll' \
--header 'Content-Type: application/json;charset=utf-8' \
--data '{
    "name": "new",
    "quantity": 10
}'
```
