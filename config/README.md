Spring Cloud Configuration Server Example
=========================================

This example contains 3 projects:

 * config-server : A simple Spring Boot CLI application that fires up a Spring Cloud configuration server listening on port 8888 and drawing its configuration from GitHub.
 * config-client : A Spring Boot application that draws configuration properties from the configuration server.
 * myapp-config : A project containing only configuration properties. This is the project on GitHub that the configuration server draws configuration from.

To run the projects, you must have the Spring Cloud CLI installed into Spring Boot CLI:

```sh
$ spring install org.springframework.cloud:spring-cloud-cli:1.0.0.RELEASE
```

Start the config-server first:

```sh
$ cd config-server
$ spring run .
```

Then start the config-client (in a separate shell):

```sh
$ cd config-client
$ spring run .
```

From yet another shell, issue a GET request to the client:

```sh
$ curl localhost:8080
```

You should see a greeting populated with a value from the application.properties in the GitHub repository.

If you check the environment (http://localhost:8080/env) for the client, you should see, near the top, a reference to the properties fetched from the configuration server:

```
configService:https://github.com/habuma/myapp-config.git/application.properties: {
    myapp.who: "GitHub configuration repo"
},
```
