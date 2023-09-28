package com.rdi.cmsystem.services;

import com.rdi.cmsystem.data.models.Customer;
import com.rdi.cmsystem.data.repositories.CustomerRepository;
import com.rdi.cmsystem.dto.request.UpdateCustomerDetailsRequest;
import com.rdi.cmsystem.dto.response.CustomerResponse;
import com.rdi.cmsystem.dto.response.RegisterCustomerResponse;
import com.rdi.cmsystem.dto.request.RegisterCustomerRequest;
import com.rdi.cmsystem.dto.response.UpdateCustomerDetailsResponse;
import com.rdi.cmsystem.exceptions.CustomerNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final ModelMapper mapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    public List<CustomerResponse> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> mapper.map(customer, CustomerResponse.class))
                .toList();
    }

    @Override
    public CustomerResponse getCustomer(Long customerId) {
        Customer customer = findCustomer(customerId);
        return mapper.map(customer, CustomerResponse.class);
    }

    @Override
    public void deleteCustomer(Long Id) {
        Customer customer = findCustomer(Id);
        customerRepository.delete(customer);
    }

    private Customer findCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with Id "+ customerId +" could not be found"));
    }

    @Override
    public RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest) {
        Customer customer = mapper.map(registerCustomerRequest, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        return mapper.map(savedCustomer, RegisterCustomerResponse.class);
    }

    @Override
    public UpdateCustomerDetailsResponse updateCustomerDetails
            (UpdateCustomerDetailsRequest updateCustomerDetailsRequest) {
        Customer customer = mapper.map(updateCustomerDetailsRequest, Customer.class);
        Customer updatedCustomer = customerRepository.save(customer);
        return mapper.map(updatedCustomer, UpdateCustomerDetailsResponse.class);
    }
}
