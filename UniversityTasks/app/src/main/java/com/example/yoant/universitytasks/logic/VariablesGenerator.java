package com.example.yoant.universitytasks.logic;

import java.util.Random;

public abstract class VariablesGenerator {
    private static Random random = new Random();
    private static StringBuilder builder = new StringBuilder();
    private static int startingIndex = 65;

    public static String createRandomWord() {
        int letterNumber;
        builder.setLength(0);
        for (int i = 0; i < 10; i++) {
            do {
                letterNumber = random.nextInt() % 57;
            } while ((startingIndex + letterNumber >= 91 && startingIndex + letterNumber < 97) ||
                    (startingIndex + letterNumber < 65) ||
                    (startingIndex + letterNumber > 122));
            builder.append((char) (startingIndex + letterNumber));
        }
        return builder.toString();
    }

    public static int createRandomKey() {
        return Math.abs(random.nextInt() % 26);
    }
}
