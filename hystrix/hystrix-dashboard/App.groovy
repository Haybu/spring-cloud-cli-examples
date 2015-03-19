import org.springframework.ui.freemarker.SpringTemplateLoader;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.cloud.netflix.hystrix.*

@Configuration
@EnableHystrixDashboard
class App {

	private static final String DEFAULT_TEMPLATE_LOADER_PATH = "classpath:/templates/";

	private static final String DEFAULT_CHARSET = "UTF-8";
	
	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer() {
		System.out.println("OK")
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPaths(DEFAULT_TEMPLATE_LOADER_PATH);
		configurer.setDefaultEncoding(DEFAULT_CHARSET);
		configurer.setPreferFileSystemAccess(false);
		return configurer;
	}

}