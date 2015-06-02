import org.springframework.cloud.netflix.hystrix.*

@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@RestController
class App {

	@Autowired
	HelloHelper helloHelper

	@RequestMapping("/")
	def hello() {
		helloHelper.getGreetingY()
	}

	@RequestMapping("/x")
	def hellox() {
		helloHelper.getStuffY()
	}

}