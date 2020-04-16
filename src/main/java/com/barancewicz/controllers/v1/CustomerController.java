package com.barancewicz.controllers.v1;

import com.barancewicz.api.v1.model.CategoryDTO;
import com.barancewicz.api.v1.model.CategoryListDTO;
import com.barancewicz.api.v1.model.CustomerDTO;
import com.barancewicz.api.v1.model.CustomersListDTO;
import com.barancewicz.services.CategoryService;
import com.barancewicz.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomersListDTO> getAllCustomers(){
        return new ResponseEntity<CustomersListDTO>(
                new CustomersListDTO(customerService.getAllCustomers()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id){
        return new ResponseEntity<CustomerDTO>(
                customerService.getCustomerById(id), HttpStatus.OK);
    }
}
