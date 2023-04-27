package com.example.zadanie261.home;

import com.example.zadanie261.recipe.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final RecipeService recipeService;

    public HomeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("threeMostLikedRecipes", recipeService.find3MostLikedRecipes());
        return "home";
    }
}
