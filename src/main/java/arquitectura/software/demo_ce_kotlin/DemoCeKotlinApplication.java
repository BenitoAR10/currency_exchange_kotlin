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

		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

		JoranConfigurator configurator = new JoranConfigurator();
		configurator.setContext(loggerContext);
		loggerContext.reset();
		try {
			configurator.doConfigure("src/main/java/logback.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
