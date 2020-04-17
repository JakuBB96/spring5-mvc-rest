package com.barancewicz.controllers.v1;

import com.barancewicz.api.v1.model.CategoryDTO;
import com.barancewicz.api.v1.model.CategoryListDTO;
import com.barancewicz.api.v1.model.CustomerDTO;
import com.barancewicz.api.v1.model.CustomersListDTO;
import com.barancewicz.services.CategoryService;
import com.barancewicz.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Api(description = "This is customer controller")
@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @ApiOperation(value = "This will get a list of customers", notes = "Here are some implementation notes")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomersListDTO getListOfCustomers() {
        return new CustomersListDTO(customerService.getAllCustomers());
    }
    @ApiOperation(value = "This returns single customer", notes = "Here are some implementation notes")
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @ApiOperation(value = "This will create a customer", notes = "Here are some implementation notes")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createNewCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createNewCustomer(customerDTO);
    }
    @ApiOperation(value = "This will update a customer", notes = "Here are some implementation notes")
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return customerService.saveCustomerByDTO(id, customerDTO);
    }
    @ApiOperation(value = "This will update given property of customer", notes = "Here are some implementation notes")
    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO patchCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        return customerService.patchCustomer(id, customerDTO);
    }
    @ApiOperation(value = "This will delete a signle customer", notes = "Here are some implementation notes")
    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }
}