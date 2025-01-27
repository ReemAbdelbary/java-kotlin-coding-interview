package com.example.task.choice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomChoiceGeneratorTest {

    @Test
    void generateChoice() {
        RandomChoiceGenerator generator = new RandomChoiceGenerator();
        for (int i = 0; i < 100; i++) {
            String choice = generator.generateChoice();
            assertTrue(choice.equals("rock") || choice.equals("paper") || choice.equals("scissors"));
        }
    }
}