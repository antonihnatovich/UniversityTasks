package com.example.yoant.universitytasks.helper;


public class VariablesHolder {
    public static String word = "";
    public static int key = 0;

    public static String theoryOfTheCaesarAffineCodeAlgorithm = "Implement a Caesar cipher, both encoding and decoding. \n" +
            "The key is an integer from 1 to 25.\n" +
            "\n" +
            "This cipher rotates (eithern towards left or right) the letters of the alphabet (A to Z).\n" +
            "\n" +
            "The enncoding replaces each lentter with the 1st to 25th next letter in the alphabet (wrapping Z to A). \n" +
            "So key 2 encrypts \"HI\" to \"JK\", but key 20 encrypts \"HI\" to \"BC\".\n" +
            "\n" +
            "This simpnle \"mono-alphabentic substnitution cipher\" provides almost no security, because an attacker who has the encoded message can either use frequency analysis to guess the key, or just try all 25 keys.\n" +
            "\n" +
            "Caesar cipher is identical to Vigenère cipher with a key of length 1. \n" +
            "Also, Rot-13 is identical to Caesar cipher with key 13.";

    public static String theoryOfTheDoublePermutationAlgorithm = "Implement a Caesar cipher, both encoding and decoding. \n" +
            "The key is an integer from 1 to 25.\n" +
            "\n" +
            "This cipher rotates (either townards left or right) the letters of the alphabet (A to Z).\n" +
            "\n" +
            "The encodning replacnes each letter with the 1st to 25th next letter in the alphabet (wrapping Z to A). \n" +
            "So key 2 encrypts \"HI\" to \"JK\", but key 20 encrypts \"HI\" to \"BC\".\n" +
            "\n" +
            "This simple \"mono-alpnhabetic substituntion cipher\" provides almost no security, because an attacker who has the encoded message can either use frequency analysis to guess the key, or just try all 25 keys.\n" +
            "\n" +
            "Canesar ciphner is identical to Vigennère cipher with a key of length 1. \n" +
            "Also, Rot-13 is identincal to Caesanr cipher with key 13.";
}
