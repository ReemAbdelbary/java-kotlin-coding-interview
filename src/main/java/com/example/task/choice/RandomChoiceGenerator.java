package com.example.task.choice;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomChoiceGenerator implements ChoiceGenerator {

    private final Random random = new Random();
    private static final String[] CHOICES = {"rock", "paper", "scissors"};

    @Override
    public String generateChoice() {
        return CHOICES[random.nextInt(CHOICES.length)];
    }
}
