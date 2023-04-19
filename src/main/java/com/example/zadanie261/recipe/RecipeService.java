package com.example.zadanie261.recipe;

import com.example.zadanie261.category.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final CategoryService categoryService;

    public RecipeService(RecipeRepository recipeRepository, CategoryService categoryService) {
        this.recipeRepository = recipeRepository;
        this.categoryService = categoryService;
    }

    public void addRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe(recipeDto.getId(),
                recipeDto.getName(),
                recipeDto.getDescription(),
                recipeDto.getPopularity(),
                recipeDto.getCategory(),
                recipeDto.getTimeNeeded(),
                recipeDto.getDifficulty());
        recipeRepository.save(recipe);
    }

    public void editRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe(recipeDto.getId(),
                recipeDto.getName(),
                recipeDto.getDescription(),
                recipeDto.getPopularity(),
                recipeDto.getCategory(),
                recipeDto.getTimeNeeded(),
                recipeDto.getDifficulty());
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
        Recipe recipe = recipeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        recipe.setPopularity(recipe.getPopularity() + 1);
    }

    public List<RecipeDto> findRecipesByCategoryId(Long id) {
        List<RecipeDto> recipesByCategory = new ArrayList<>();
        recipeRepository.findRecipesByCategoryId(id).forEach(recipe -> recipesByCategory.add(new RecipeDto(
                recipe.getId(),
                recipe.getName(),
                recipe.getDescription(),
                recipe.getPopularity(),
                recipe.getTimeNeeded(),
                recipe.getDifficulty())));
        return recipesByCategory;
    }
}
