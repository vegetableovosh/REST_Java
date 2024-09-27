package com.vegetable.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {

		SpringApplication.run(PracticeApplication.class, args);
	}

}


