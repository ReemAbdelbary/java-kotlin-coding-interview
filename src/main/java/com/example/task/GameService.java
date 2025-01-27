package com.example.task;

import com.example.task.choice.ChoiceGenerator;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final ChoiceGenerator choiceGenerator;

    public GameService(ChoiceGenerator choiceGenerator) {
        this.choiceGenerator = choiceGenerator;
    }

    public GameResult playGame(int rounds) {
        int playerAWins = 0;
        int playerBWins = 0;
        int draws = 0;

        for (int i = 0; i < rounds; i++) {
            String playerAChoice = "rock";
            String playerBChoice = choiceGenerator.generateChoice();
            String result = evaluateRoundResult(playerAChoice, playerBChoice);

            switch (result) {
                case "Player A Wins":
                    playerAWins++;
                    break;
                case "Player B Wins":
                    playerBWins++;
                    break;
                case "Draw":
                    draws++;
                    break;
            }
        }
        return new GameResult(playerAWins, playerBWins, draws, rounds);
    }

    private String evaluateRoundResult(String playerAChoice, String playerBChoice) {
        if (playerAChoice.equals(playerBChoice)) {
            return "Draw";
        }

        if ((playerAChoice.equals("rock") && playerBChoice.equals("scissors")) ||
                (playerAChoice.equals("scissors") && playerBChoice.equals("paper")) ||
                (playerAChoice.equals("paper") && playerBChoice.equals("rock"))) {
            return "Player A Wins";
        }

        return "Player B Wins";
    }
}
