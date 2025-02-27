package com.supermarket_management_system.services;



import com.supermarket_management_system.dto.CategoryDto;
import com.supermarket_management_system.entities.Category;
import com.supermarket_management_system.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        var category = categoryRepository.findById(id).orElseThrow();
        return convertToDto(category);
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        var category = new Category();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return convertToDto(category);
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        var category = categoryRepository.findById(id).orElseThrow();
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
        return convertToDto(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    private CategoryDto convertToDto(Category category) {
        var categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }
}

