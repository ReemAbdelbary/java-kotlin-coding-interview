package com.example.task;


public class GameResult {
    private final int playerAWins;
    private final int playerBWins;
    private final int draws;
    private final int totalRounds;

    public GameResult(int playerAWins, int playerBWins, int draws, int totalRounds) {
        this.playerAWins = playerAWins;
        this.playerBWins = playerBWins;
        this.draws = draws;
        this.totalRounds = totalRounds;
    }

    public void printResults() {
        System.out.println("Player A wins " + playerAWins + " of " + totalRounds + " games");
        System.out.println("Player B wins " + playerBWins + " of " + totalRounds + " games");
        System.out.println("Draws: " + draws + " of " + totalRounds + " games");
    }

    public int getPlayerAWins() {
        return playerAWins;
    }

    public int getPlayerBWins() {
        return playerBWins;
    }

    public int getDraws() {
        return draws;
    }

    public int getTotalRounds() {
        return totalRounds;
    }
}
