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

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void addRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe(recipeDto.getName(),
                recipeDto.getDescription(),
                recipeDto.getPopularity(),
                recipeDto.getCategory(),
                recipeDto.getTimeNeeded(),
                recipeDto.getDifficulty());
        recipeRepository.save(recipe);
    }

    public void editRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeRepository.findById(recipeDto.getId()).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        toDto(recipe);
        recipeRepository.save(recipe);
    }

    public List<RecipeDto> find3MostLikedRecipes() {
        return recipeRepository.findTop3ByOrderByPopularityDesc().stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<RecipeDto> findAllRecipes() {
        return recipeRepository.findAllByOrderByCategoryAsc().stream().map(this::toDto).collect(Collectors.toList());
    }

    public Optional<RecipeDto> findById(Long id) {
        return recipeRepository.findById(id).map(this::toDto);
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
        return recipeRepository.findRecipesByCategoryId(id)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private RecipeDto toDto(Recipe recipe) {
        RecipeDto recipeDto = new RecipeDto();
        recipe.setName(recipeDto.getName());
        recipe.setDescription(recipeDto.getDescription());
        recipe.setPopularity(recipeDto.getPopularity());
        recipe.setCategory(recipeDto.getCategory());
        recipe.setTimeNeeded(recipeDto.getTimeNeeded());
        recipe.setDifficulty(recipeDto.getDifficulty());
        return recipeDto;
    }
}
