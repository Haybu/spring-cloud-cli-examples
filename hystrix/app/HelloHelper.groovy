@Grab("com.netflix.hystrix:hystrix-javanica:1.3.20")
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.web.client.RestOperations

@Component
class HelloHelper {

	@Autowired
	RestOperations rest

	@HystrixCommand(fallbackMethod = "defaultMessage")
	def getMessage() {
		rest.getForObject("http://HelloService/hello", String.class)
	}

	@HystrixCommand(fallbackMethod = "getMoreStuff")
	def getStuff() {
		throw new Exception("Oops");
	}

	@HystrixCommand(fallbackMethod = "anotherFallback")
	def getMoreStuff() {
		throw new Exception("Oops");
	}

	def defaultMessage() {
		"What happened?"
	}

	def anotherFallback() {
		"Huh?"
	}

}