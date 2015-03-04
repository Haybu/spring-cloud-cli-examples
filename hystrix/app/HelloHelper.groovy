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

	def defaultMessage() {
		"What happened?"
	}

}