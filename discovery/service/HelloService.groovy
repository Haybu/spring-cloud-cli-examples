@EnableDiscoveryClient
@RestController
class HelloService {

	@RequestMapping("/hello")
	def hello() {
		"Hello world!"
	}

}