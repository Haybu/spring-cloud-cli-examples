import org.springframework.web.client.RestOperations

@EnableDiscoveryClient
@RestController
class App {

	@Autowired
	RestOperations rest

	@RequestMapping("/")
	def hello() {
		rest.getForObject("http://HelloService/hello", String.class)
	}

}