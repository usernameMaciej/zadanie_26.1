package com.example.zadanie261.category;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAllByOrderByNameDesc();
    }

    public CategoryDto findById(Long id) {
        return categoryRepository.findById(id)
                .map(category -> new CategoryDto(category.getId(), category.getName(), category.getDescription(), category.getImg()))
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
    }
}
