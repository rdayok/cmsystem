package com.rdi.cmsystem.controllers;

import com.rdi.cmsystem.data.models.Customer;
import com.rdi.cmsystem.dto.response.RegisterCustomerResponse;
import com.rdi.cmsystem.dto.request.RegisterCustomerRequest;
import com.rdi.cmsystem.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer() {
        List<Customer> allCustomers = customerService.getCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId) {
        Customer gottenCustomer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(gottenCustomer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegisterCustomerResponse> registerCustomer
            (@RequestBody RegisterCustomerRequest registerCustomerRequest) {
        RegisterCustomerResponse registeredCustomer =
                customerService.registerCustomer(registerCustomerRequest);
        return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer addedCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(addedCustomer, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }
}
