package com.example.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class TaskApplicationTests {

	@Autowired
	private GameService gameService;

	@Test
	void testPlayGameIntegration() {
		GameResult result = gameService.playGame(100);

		int totalGames = result.getPlayerAWins() + result.getPlayerBWins() + result.getDraws();
		assertTrue(totalGames == 100);
	}

}
