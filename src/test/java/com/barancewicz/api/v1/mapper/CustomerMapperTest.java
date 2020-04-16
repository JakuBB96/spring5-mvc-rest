package com.barancewicz.api.v1.mapper;

import com.barancewicz.api.v1.model.CategoryDTO;
import com.barancewicz.api.v1.model.CustomerDTO;
import com.barancewicz.domain.Category;
import com.barancewicz.domain.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {

    public static final String F_NAME = "Mike";
    public static final String L_NAME = "Carlisnky";
    public static final long ID = 1L;
    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    void customerToCustomerDTO() {

        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(F_NAME);
        customer.setLastName(L_NAME);

        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        assertEquals(Long.valueOf(ID), customerDTO.getId());
        assertEquals(F_NAME, customerDTO.getFirstName());
        assertEquals(L_NAME, customerDTO.getLastName());
    }
}




