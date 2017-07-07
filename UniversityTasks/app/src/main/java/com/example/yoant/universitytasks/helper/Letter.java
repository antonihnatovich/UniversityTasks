package com.example.yoant.universitytasks.helper;

public class Letter {
    public String letterFresh;
    public String letterFlipped;
    public int codeFresh;
    public int codeFlipepd;
    public boolean isFlipped;

    public Letter(String letter, String cryptedValue, int keyFresh, int keyFlipepd) {
        this.letterFresh = letter;
        this.letterFlipped = cryptedValue;
        this.codeFresh = keyFresh;
        this.codeFlipepd = keyFlipepd;
        isFlipped = false;
    }

}
