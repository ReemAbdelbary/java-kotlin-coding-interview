package com.example.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication implements CommandLineRunner {

	private final GameService gameService;

	public TaskApplication(GameService gameService) {
		this.gameService = gameService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);

	}

	@Override
	public void run(String... args) {
		final int TOTAL_ROUNDS = 100;
		GameResult result = gameService.playGame(TOTAL_ROUNDS);
		result.printResults();
	}
}


