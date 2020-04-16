package com.barancewicz.services;

import com.barancewicz.api.v1.mapper.CategoryMapper;
import com.barancewicz.api.v1.model.CategoryDTO;
import com.barancewicz.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
       // List<CategoryDTO> categoryDTOS = new ArrayList<>();
       // categoryRepository.findAll().forEach(category -> categoryDTOS.add(categoryMapper.categoryToCategoryDTO(category)));
        // return categoryDTOS;
        return categoryRepository.findAll()
                        .stream()
                        .map(categoryMapper::categoryToCategoryDTO)
                        .collect(Collectors.toList());

    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));
    }
}
