package com.example.zadanie261.recipe;

import com.example.zadanie261.category.Category;

public class RecipeDto {
    private Long id;
    private String name;
    private String description;
    private int popularity;
    private int timeNeeded;
    private Difficulty difficulty;
    private Category category;

    public RecipeDto() {
    }

    public RecipeDto(Long id, String name, String description, int popularity, int timeNeeded, Difficulty difficulty) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.popularity = popularity;
        this.timeNeeded = timeNeeded;
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getTimeNeeded() {
        return timeNeeded;
    }

    public void setTimeNeeded(int timeNeeded) {
        this.timeNeeded = timeNeeded;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
