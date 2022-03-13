_**This project is a hobby project and is still a work in
progress, so if something is not running please don't be mad**_ :smile:

# Learning Track (Back-end)
This is the back-end part of the LSDP (Learn-Solve-Document-Progress) web-app. The 
front-end counterpart can be found [here](https://github.com/luke-ken/learning-track-frontend-angular).

(**Make sure to check out the front-end part too as both are intent to run together!**)

## Prerequisites
* Java 17
* Maven

## Configuration
Before running the app, you need to configure the JWT secret key that is used
for the user authentication. Open the file `/src/main/resources/application.properties`
and fill in the value for `security.jwt.token.secret-key`.
The value is up to you, just make sure it's long enough (mine is around 60 characters).

## Running with Docker
This app uses MongoDB as database, so you need to pull the mongodb docker image:
```
docker pull mongo
```
This will pull the latest image of mongodb. If you want to use a specific version/tag with the app, make sure 
to change the appropriate value inside the `docker-compose.yml` file.

Now build the app with Maven by running the following:
```
mvn clean install -DskipTests
```
After the successful build, run the following to start up the app:
```
docker compose up --build
```

### _Side note_:
If you want to run the app with an older version of Java and Maven, change these following configuration:
* `java.version` inside the `pom.xml` file (you might also need to change the `lombok` dependency version)
* the base image inside the `Dockerfile`