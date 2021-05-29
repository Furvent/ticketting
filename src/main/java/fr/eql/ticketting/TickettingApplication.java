package fr.eql.ticketting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TickettingApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(TickettingApplication.class);
		app.setAdditionalProfiles("initData");
		ConfigurableApplicationContext context = app.run(args);
	}

}
