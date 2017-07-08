package com.example.yoant.universitytasks.logic;

public abstract class Cryptographer {

    private static StringBuilder builder = new StringBuilder();
    private static final int constantFinalCaesarMultiplier = 5;

    public static String cryptCaesarDecrypt(String line, int move1) {
//        int move2 = constantFinalCaesarMultiplier;
//        for (int i = 0; i < line.length(); i++) {
//            int w = convert(move2, line.toCharArray()[i] - 65);
//            char c = (char) (65 + (w / move2 - move1) % 26);
//            if ((int) (c) < 65) {
//                c = (char) ((int) (c) + 26);
//            }
//            builder.append(c);
//        }
//        String toReturn = builder.toString();
//        builder.setLength(0);
        builder.setLength(0);
        return cryptCaesarCrypt(line, 26 - move1);
    }

    public static String cryptCaesarCrypt(String line, int move1) {
        move1 = move1 % 26 + 26;
        builder.setLength(0);
        for (char i : line.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    builder.append((char) ('A' + (i - 'A' + move1) % 26));
                } else {
                    builder.append((char) ('a' + (i - 'a' + move1) % 26));
                }
            } else {
                builder.append(i);
            }
        }
        return builder.toString();
    }
}