package com.barancewicz.api.v1.mapper;

import com.barancewicz.api.v1.model.CategoryDTO;
import com.barancewicz.domain.Category;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


class CategoryMapperTest {


    public static final String NAME = "testCat";
    public static final long ID = 1L;
    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    void categoryToCategoryDTO() {

        Category category = new Category();
        category.setId(ID);
        category.setName(NAME);

        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);
        assertEquals(Long.valueOf(ID), categoryDTO.getId());
        assertEquals(NAME, categoryDTO.getName());
    }
}