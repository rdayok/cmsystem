package com.rdi.cmsystem.services;

import com.rdi.cmsystem.data.models.Customer;
import com.rdi.cmsystem.dto.response.RegisterCustomerResponse;
import com.rdi.cmsystem.dto.request.RegisterCustomerRequest;

import java.util.List;


public interface CustomerService {

    List<Customer> getCustomers();

    Customer getCustomer(Long customerId);

    Customer addCustomer(Customer customer);

    void deleteCustomer(Long id);

    RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest);
}

