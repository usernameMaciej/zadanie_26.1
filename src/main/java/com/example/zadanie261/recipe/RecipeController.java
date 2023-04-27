package com.example.zadanie261.recipe;

import com.example.zadanie261.category.CategoryDto;
import com.example.zadanie261.category.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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
        model.addAttribute("recipe", new RecipeDto());
        model.addAttribute("categories", findCategoriesToModel());
        model.addAttribute("mode", "add");
        return "upsertRecipe";
    }

    @PostMapping("/add")
    public String addRecipe(RecipeDto recipeDto) {
        recipeService.addRecipe(recipeDto);
        return "redirect:/";
    }

    @GetMapping("/recipe/edit/id/{id}")
    public String showRecipeEditForm(@PathVariable Long id, Model model) {
        RecipeDto recipe = recipeService.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", findCategoriesToModel());
        return "upsertRecipe";
    }

    @PostMapping("/edit")
    public String editRecipe(RecipeDto recipeDto) {
        recipeService.editRecipe(recipeDto);
        return "redirect:/recipes";
    }

    @GetMapping("/recipe/id/{id}")
    public String singleRecipe(@PathVariable Long id, Model model) {
        RecipeDto recipe = recipeService.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        model.addAttribute("singleRecipe", recipe);
        return "singleRecipe";
    }

    @GetMapping("/recipe/delete/id/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeService.deleteRecipeById(id);
        return "redirect:/";
    }

    @GetMapping("/recipes")
    public String findAllRecipes(Model model) {
        model.addAttribute("recipes", recipeService.findAllRecipes());
        return "recipes";
    }

    @GetMapping("/like/id/{id}")
    public String like(@PathVariable Long id) {
        RecipeDto recipe = recipeService.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
        recipeService.addLike(id);
        return "redirect:/recipe/id/" + recipe.getId();
    }

    private List<CategoryDto> findCategoriesToModel() {
        return categoryService.findAllCategories();
    }
}
