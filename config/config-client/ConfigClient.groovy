@RestController
class ConfigClient {

	@Value('${myapp.who}')
	String who

	@RequestMapping("/")
	def hello() {
		"Hello from " + who
	}

}