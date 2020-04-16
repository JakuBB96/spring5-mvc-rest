package com.barancewicz.repositories;

import com.barancewicz.domain.Category;
import com.barancewicz.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
