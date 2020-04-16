package com.barancewicz.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class CustomersListDTO {
    List<CustomerDTO> customers;
}