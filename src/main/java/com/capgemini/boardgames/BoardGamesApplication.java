package com.capgemini.boardgames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class BoardGamesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardGamesApplication.class, args);
	}
}
