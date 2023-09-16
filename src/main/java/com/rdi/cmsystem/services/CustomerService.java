package com.rdi.cmsystem.services;

import com.rdi.cmsystem.data.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    List<Customer> getCustomers();

    Customer getCustomer(Long customerId);

    Customer addCustomer(Customer customer);

    void deleteCustomer(Long id);
}
