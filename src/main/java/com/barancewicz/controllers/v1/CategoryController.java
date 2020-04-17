package com.barancewicz.controllers.v1;


import com.barancewicz.api.v1.model.CategoryDTO;
import com.barancewicz.api.v1.model.CategoryListDTO;
import com.barancewicz.services.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Api(description = "This is category controller")
@RestController
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {
    public static final String BASE_URL = "/api/v1/categories/";
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @ApiOperation(value = "List of categories", notes = "Here are some implementation notes")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getAllCategories(){
       return new CategoryListDTO(categoryService.getAllCategories());
    }
    @ApiOperation(value = "Get Category by Name", notes = "Here are some implementation notes")
    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name){
        return categoryService.getCategoryByName(name);
    }
}
