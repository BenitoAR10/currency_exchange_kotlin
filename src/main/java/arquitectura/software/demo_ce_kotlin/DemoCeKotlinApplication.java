package arquitectura.software.demo_ce_kotlin;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoCeKotlinApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoCeKotlinApplication.class, args);


	}

}
