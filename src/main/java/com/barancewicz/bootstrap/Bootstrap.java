package com.barancewicz.bootstrap;


import com.barancewicz.domain.Category;
import com.barancewicz.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;

    public Bootstrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category fruits = new Category();
        Category dried = new Category();
        Category fresh = new Category();
        Category exotic = new Category();
        Category nuts = new Category();
        fruits.setName("Fruits");
        exotic.setName("Exotic");
        fresh.setName("Fresh");
        nuts.setName("Nuts");
        dried.setName("Dried");
        categoryRepository.save(fruits);
        categoryRepository.save(exotic);
        categoryRepository.save(fresh);
        categoryRepository.save(nuts);
        categoryRepository.save(dried);

        System.out.println("Data loaded = " + categoryRepository.count());
    }
}
