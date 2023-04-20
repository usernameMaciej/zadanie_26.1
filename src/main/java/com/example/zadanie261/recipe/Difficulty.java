package com.example.zadanie261.recipe;

public enum Difficulty {
    EASY("Łatwe"),
    MEDIUM("Średnie"),
    HARD("Trudne");

    private final String plTranslation;

    Difficulty(String plTranslation) {
        this.plTranslation = plTranslation;
    }

    public String getPlTranslation() {
        return plTranslation;
    }
}
