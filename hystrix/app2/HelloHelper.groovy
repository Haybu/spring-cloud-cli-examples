@Grab("com.netflix.hystrix:hystrix-javanica:1.3.20")
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.web.client.RestOperations

@Component
class HelloHelper {

	@Autowired
	RestOperations rest

	@HystrixCommand(fallbackMethod = "defaultMessage")
	def getGreeting() {
		rest.getForObject("http://HelloService/hello", String.class)
	}

	@HystrixCommand(fallbackMethod = "getMoreStuffX")
	def getStuffX() {
		throw new Exception("Oops");
	}

	@HystrixCommand(fallbackMethod = "anotherFallback")
	def getMoreStuffX() {
		throw new Exception("Oops");
	}

	def defaultMessage() {
		"What happened?"
	}

	def anotherFallback() {
		"Huh?"
	}

}