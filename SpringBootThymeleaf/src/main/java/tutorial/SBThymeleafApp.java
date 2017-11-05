package tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
public class SBThymeleafApp {
	public static void main(String[] args) {
		SpringApplication.run(SBThymeleafApp.class, args);
	}
}
