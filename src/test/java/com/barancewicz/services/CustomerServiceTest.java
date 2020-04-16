package com.barancewicz.services;

import com.barancewicz.api.v1.mapper.CategoryMapper;
import com.barancewicz.api.v1.mapper.CustomerMapper;
import com.barancewicz.api.v1.model.CategoryDTO;
import com.barancewicz.api.v1.model.CustomerDTO;
import com.barancewicz.domain.Category;
import com.barancewicz.domain.Customer;
import com.barancewicz.repositories.CategoryRepository;
import com.barancewicz.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CustomerServiceTest {
    public static final String F_NAME = "Mike";
    public static final String L_NAME = "Carlisnky";
    public static final long ID = 1L;
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
    }

    @Test
    void getAllCustomers() {

        List<Customer> customerList = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customerList);

        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        assertEquals(customerList.size(), customerDTOS.size());

    }


    @Test
    void getCustomerById() {

        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstName(F_NAME);
        customer.setLastName(L_NAME);

        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));

        CustomerDTO customerDTO = customerService.getCustomerById(ID);

        assertEquals(ID, customer.getId());
        assertEquals(F_NAME, customerDTO.getFirstName());
        assertEquals(L_NAME, customerDTO.getLastName());

    }
}

