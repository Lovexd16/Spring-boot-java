package com.hello.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "<h1>Hello world!</h1>";
	}

	@GetMapping("/vem")
	public String vem(@RequestParam(value = "name", defaultValue = "Okänd") String name) {
		return String.format("Hej på dig %s!", name);
	}

}
