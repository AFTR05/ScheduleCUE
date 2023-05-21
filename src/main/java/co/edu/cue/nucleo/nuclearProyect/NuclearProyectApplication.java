package co.edu.cue.nucleo.nuclearProyect;

import co.edu.cue.nucleo.nuclearProyect.domain.entities.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NuclearProyectApplication {
	public static void main(String[] args) {
		SpringApplication.run(NuclearProyectApplication.class, args);
		Student e=new Student();
	}
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);

	}

}
