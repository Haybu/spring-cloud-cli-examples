@Grab("spring-cloud-starter-turbine")

import org.springframework.cloud.netflix.turbine.EnableTurbine

@EnableTurbine
@EnableDiscoveryClient
class App {
}