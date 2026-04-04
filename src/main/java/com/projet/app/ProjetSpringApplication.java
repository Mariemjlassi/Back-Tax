package com.projet.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@EnableTransactionManagement
@SpringBootApplication
public class ProjetSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetSpringApplication.class, args);
	}

}
