package msa.containerapp.javarestemployeeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Properties;

@SpringBootApplication
public class JavaRestEmployeeApiApplication {
	static final String PORT_PROPERTY = "PORT";

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(JavaRestEmployeeApiApplication.class)  ;
		
		String tomcatEnv = System.getenv("PORT");
		// if a TOMCATENV was set, then get it's value and set the appropriate Spring profile
		if(tomcatEnv != null) {
			Properties properties = new Properties();
			properties.put(PORT_PROPERTY, tomcatEnv);
			application.setDefaultProperties(properties);
		}

		application.run(args);
	}
}
