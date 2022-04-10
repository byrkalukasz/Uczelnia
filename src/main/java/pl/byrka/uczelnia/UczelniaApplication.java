package pl.byrka.uczelnia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class UczelniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UczelniaApplication.class, args);
	}

}
