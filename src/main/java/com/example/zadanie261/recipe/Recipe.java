package com.example.zadanie261.recipe;

import com.example.zadanie261.category.Category;
import jakarta.persistence.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 1777)
    private String description;
    private int popularity;
    @ManyToOne
    private Category category;
    private int timeNeeded;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    public Recipe() {
    }

    public Recipe(Long id, String name, String description, int popularity, Category category, int timeNeeded, Difficulty difficulty) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.popularity = popularity;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
}
