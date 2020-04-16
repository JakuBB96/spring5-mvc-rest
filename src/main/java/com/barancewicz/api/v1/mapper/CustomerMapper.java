package com.barancewicz.api.v1.mapper;

import com.barancewicz.api.v1.model.CategoryDTO;
import com.barancewicz.api.v1.model.CustomerDTO;
import com.barancewicz.domain.Category;
import com.barancewicz.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source = "id", target = "id")
    CustomerDTO customerToCustomerDTO(Customer customer);

}
