Spring Cloud Service Discovery Example
======================================

This example contains 3 projects:

 * eureka : A simple Spring Boot application that starts a Eureka discovery server.
 * service : A simple Spring Boot application that contains a Eureka client to register the service with the Eureka server
 * app : A simple Spring Boot application that contains a Eureka client to discover the service and consume it via RestTemplate.

To run the projects, you must have the Spring Cloud CLI installed into Spring Boot CLI:

```sh
$ spring install org.springframework.cloud:spring-cloud-cli:1.0.0.RELEASE
```

Start the eureka app first:

```sh
$ cd eureka
$ spring run .
```

Then start the service (in a separate shell):

```sh
$ cd service
$ spring run .
```

From yet another shell, start the app:

```sh
$ cd app
$ spring run .
```

In a separate shell, consume the app project's endpoint:

```sh
$ curl localhost:8080
```

You should be greeted with the greeting returned from the GET request made to the service. 

The key things to note:
 * The service will be listening on localhost port 8081
 * The app will consume it (via RestTemplate) via its service name ("HelloWorld") and not at http://localhost:8081

