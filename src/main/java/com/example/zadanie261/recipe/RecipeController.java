package com.example.zadanie261.recipe;

import com.example.zadanie261.category.Category;
import com.example.zadanie261.category.CategoryService;
import com.example.zadanie261.exception.RecipeNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class RecipeController {
    private final RecipeService recipeService;
    private final CategoryService categoryService;

    public RecipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping("/add")
    public String addRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        model.addAttribute("categories", findCategoriesToModel());
        return "add";
    }

    @PostMapping("/add")
    public String addRecipe(Recipe recipe) {
        recipeService.addRecipe(recipe);
        return "redirect:/";
    }

    @GetMapping("/recipe/edit/id={id}")
    public String showRecipeEditForm(@PathVariable Long id, Model model) {
        Recipe recipe = recipeService.findById(id).orElseThrow(RecipeNotFoundException::new);
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", findCategoriesToModel());
        return "edit";
    }

    @GetMapping("/recipe/id={id}")
    public String singleRecipe(@PathVariable Long id, Model model) {
        Optional<Recipe> recipe = recipeService.findById(id);

        if (recipe.isPresent()) {
            Recipe singleRecipe = recipe.get();
            model.addAttribute("singleRecipe", singleRecipe);
        } else {
            throw new RecipeNotFoundException();
        }
        return "singleRecipe";
    }

    @GetMapping("/recipe/delete/id={id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipeById(id);
        return "redirect:/recipes";
    }

    @GetMapping("/recipes")
    public String findAllRecipes(Model model) {
        model.addAttribute("recipes", recipeService.findAllRecipes());
        return "recipes";
    }

    @GetMapping("/like/id={id}")
    public String like(@PathVariable Long id) {
        Optional<Recipe> likeId = recipeService.findById(id);

        if (likeId.isPresent()) {
            recipeService.addLike(id);
            return "redirect:/recipe/id=" + likeId.get().getId();
        } else {
            throw new RecipeNotFoundException();
        }
    }

    private List<Category> findCategoriesToModel() {
        return categoryService.findAllCategories();
    }
}
