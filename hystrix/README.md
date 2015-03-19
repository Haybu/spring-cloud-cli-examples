Spring Cloud Circuit Breaker Example
====================================

This example contains 4 projects:

 * eureka : A simple Spring Boot application that starts a Eureka discovery server.
 * service : A simple Spring Boot application that contains a Eureka client to register the service with the Eureka server.
 * app : A simple Spring Boot application that contains a Eureka client to discover the service and consume it via RestTemplate. It also enables a Hystrix stream and the Hystrix dashboard to monitor the health of any methods annotated with @HystrixCommand.
 * turbine : A simple Spring Boot application that fires up a Turbine stream to aggregate other Hystrix streams (in this case, only the Hystrix stream from app).

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

At this point, everything should work much like the "discovery" example. However, you can point your web browser to http://localhost:8989/hystrix to monitor the health of the one Hystrix command that the project contains. The more requests you make to http://localhost:8080, the more activity you'll see in the dashboard.

Where it gets interesting is if the Hystrix command fails. You can make it fail by stopping the service application and then making requests to http://localhost:8080. Unable to consume the message from the service, the circuit will be open and the fallback method will be called (returning "What happened?" as the response). Also, you'll notice the failure rate climbing in the Hystrix dashboard.

You can also start the application in the turbine project:

```sh
$ cd turbine
$ spring run .
```

This fires up a Turbine stream to aggregate other Hystrix streams. In this case, the aggregate stream only contains the stream from the app project, so it's a bit overkill. Nevertheless, notice how the Turbine stream discovers the other streams by looking up apps through Eureka. (In other words, it's not hardcoded with info about those other apps, other than their service names.)
