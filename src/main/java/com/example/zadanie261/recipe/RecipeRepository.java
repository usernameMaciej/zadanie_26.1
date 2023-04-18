package com.example.zadanie261.recipe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findTop3ByOrderByPopularityDesc();

    List<Recipe> findAllByOrderByCategoryAsc();
}
