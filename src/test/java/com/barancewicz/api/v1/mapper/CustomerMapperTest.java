package com.barancewicz.api.v1.mapper;

import com.barancewicz.api.v1.model.CategoryDTO;
import com.barancewicz.api.v1.model.CustomerDTO;
import com.barancewicz.domain.Category;
import com.barancewicz.domain.Customer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

class CustomerMapperTest {

    public static final String F_NAME = "Mike";
    public static final String L_NAME = "Carlisnky";
    public static final long ID = 1L;
    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    void customerToCustomerDTO() {

        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstname(F_NAME);
        customer.setLastname(L_NAME);

        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        assertEquals(Long.valueOf(ID), customerDTO.getId());
        assertEquals(F_NAME, customerDTO.getFirstname());
        assertEquals(L_NAME, customerDTO.getLastname());
    }

    @Test
    void customerDTOToCustomer() {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(ID);
        customerDTO.setFirstname(F_NAME);
        customerDTO.setLastname(L_NAME);

        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);

        assertEquals(Long.valueOf(ID), customer.getId());
        assertEquals(F_NAME, customer.getFirstname());
        assertEquals(L_NAME, customer.getLastname());
    }

}




