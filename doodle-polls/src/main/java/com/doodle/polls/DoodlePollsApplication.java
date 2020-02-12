package com.doodle.polls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DoodlePollsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoodlePollsApplication.class, args);
	}

}
