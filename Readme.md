# Webservice Game

Developed based in [springboot_docker_base](https://github.com/MiguelPazo/springboot_docker_base)

## Requirements

For building and running the application you need:

- [Open JDK 11](https://www.openlogic.com/openjdk-downloads)
- [Open JDK 11 (Windows)](https://docs.microsoft.com/es-es/java/openjdk/download)
- [Graddle 7.4](https://gradle.org/install)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method
in the `com.miguelpazo.game.Main` class from your IDE.

```shell
gradle clean build
```

## Deploying the application to Docker

The easiest way to deploy the sample application to OpenShift is to use
the [OpenShift CLI](https://docs.openshift.org/latest/cli_reference/index.html):

```shell
docker build -t webservice_game .
docker run -dp 3032:3032 -t webservice_game
```

After run docker commands you can access to endpoints:

```shell
curls -XGET http://localhost:3032
```
