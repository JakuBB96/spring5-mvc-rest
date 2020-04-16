package com.barancewicz.bootstrap;


import com.barancewicz.domain.Category;
import com.barancewicz.domain.Customer;
import com.barancewicz.repositories.CategoryRepository;
import com.barancewicz.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
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

        Customer customer = new Customer();
        customer.setFirstName("Mark");
        customer.setLastName("Twight");
        Customer customer1 = new Customer();
        customer1.setFirstName("Joe");
        customer1.setLastName("Dorris");
        customerRepository.save(customer);
        customerRepository.save(customer1);
        System.out.println("Data loaded = " + customerRepository.count());

    }
}
