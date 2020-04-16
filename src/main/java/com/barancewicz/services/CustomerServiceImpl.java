package com.barancewicz.services;

import com.barancewicz.api.v1.mapper.CustomerMapper;
import com.barancewicz.api.v1.model.CustomerDTO;
import com.barancewicz.domain.Customer;
import com.barancewicz.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                    customerDTO.setCustomer_url("/api/v1/customers/" + customer.getId());
                    return customerDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
      return customerRepository.findById(id)
              .map(customerMapper::customerToCustomerDTO)
              .orElseThrow(RuntimeException::new); //todo
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        return saveAndReturnDTO(customerMapper.customerDTOToCustomer(customerDTO));
    }

    @Override
    public CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO) {
      Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
      customer.setId(id);

      return saveAndReturnDTO(customer);
    }

    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        return customerRepository.findById(id).map(customer -> {
            if (customerDTO.getFirstName() != null){
                customer.setFirstName(customerDTO.getFirstName());
            }
            if (customerDTO.getLastName() != null){
                customer.setLastName(customerDTO.getLastName());
            }

           CustomerDTO returnDTO =  customerMapper.customerToCustomerDTO(customerRepository.save(customer));
            returnDTO.setCustomer_url("/api/v1/customer/" + id);
            return returnDTO;
        }).orElseThrow(RuntimeException::new);
    }

    private CustomerDTO saveAndReturnDTO(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO returnDto = customerMapper.customerToCustomerDTO(savedCustomer);
        returnDto.setCustomer_url("/api/v1/customer/" + savedCustomer.getId());
        return returnDto;
    }


}
