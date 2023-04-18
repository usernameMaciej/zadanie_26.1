package com.example.zadanie261.recipe;

import com.example.zadanie261.exception.RecipeNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Transactional
    @Modifying
    public void addRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
    }

    public List<Recipe> find3MostLikedRecipes() {
        return recipeRepository.findTop3ByOrderByPopularityDesc();
    }

    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAllByOrderByCategoryAsc();
    }

    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }

    @Transactional
    @Modifying
    public void addLike(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(RecipeNotFoundException::new);
        recipe.setPopularity(recipe.getPopularity() + 1);
    }

}
