package com.example.task;

import com.example.task.choice.ChoiceGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GameServiceTest {

    private GameService gameService;
    private ChoiceGenerator choiceGenerator;

    @BeforeEach
    void setUp() {
        choiceGenerator = Mockito.mock(ChoiceGenerator.class);
        gameService = new GameService(choiceGenerator);
    }

    @Test
    void testPlayerAWins() {
        when(choiceGenerator.generateChoice()).thenReturn("scissors");
        GameResult result = gameService.playGame(10);
        assertEquals(10, result.getPlayerAWins());
        assertEquals(0, result.getPlayerBWins());
        assertEquals(0, result.getDraws());
    }

    @Test
    void testPlayerBWins() {
        when(choiceGenerator.generateChoice()).thenReturn("paper");
        GameResult result = gameService.playGame(10);
        assertEquals(0, result.getPlayerAWins());
        assertEquals(10, result.getPlayerBWins());
        assertEquals(0, result.getDraws());
    }

    @Test
    void testDraws() {
        when(choiceGenerator.generateChoice()).thenReturn("rock");
        GameResult result = gameService.playGame(10);
        assertEquals(0, result.getPlayerAWins());
        assertEquals(0, result.getPlayerBWins());
        assertEquals(10, result.getDraws());
    }

    @Test
    void testMixedResultsScenario() {
        when(choiceGenerator.generateChoice())
                .thenReturn("scissors", "paper", "rock", "scissors", "rock");
        GameResult result = gameService.playGame(5);
        assertEquals(2, result.getPlayerAWins());
        assertEquals(1, result.getPlayerBWins());
        assertEquals(2, result.getDraws());
    }
}