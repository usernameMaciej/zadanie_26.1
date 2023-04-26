package com.example.zadanie261.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    String users(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("user", new UserDto());
        return "/users";
    }

    @PostMapping("/users")
    String addUser(UserDto userDto) {
        userService.addUser(userDto);
        return "redirect:/uesrs";
    }
}
