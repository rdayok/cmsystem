package com.rdi.cmsystem.controllers;

import com.rdi.cmsystem.data.models.Customer;
import com.rdi.cmsystem.dto.request.UpdateCustomerDetailsRequest;
import com.rdi.cmsystem.dto.response.CustomerResponse;
import com.rdi.cmsystem.dto.response.RegisterCustomerResponse;
import com.rdi.cmsystem.dto.request.RegisterCustomerRequest;
import com.rdi.cmsystem.dto.response.UpdateCustomerDetailsResponse;
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
    public ResponseEntity<List<CustomerResponse>> getCustomer() {
        List<CustomerResponse> customerResponses = customerService.getCustomers();
        return new ResponseEntity<>(customerResponses, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable("id") Long customerId) {
        CustomerResponse gottenCustomer = customerService.getCustomer(customerId);
        return new ResponseEntity<>(gottenCustomer, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> registerCustomer
            (@RequestBody RegisterCustomerRequest registerCustomerRequest) {
        CustomerResponse registeredCustomer =
                customerService.registerCustomer(registerCustomerRequest);
        return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UpdateCustomerDetailsResponse> updateCustomerDetails
            (@RequestBody UpdateCustomerDetailsRequest updateCustomerDetailsRequest) {
        UpdateCustomerDetailsResponse updateCustomerResponse =
                customerService.updateCustomerDetails(updateCustomerDetailsRequest);
        return new ResponseEntity<>(updateCustomerResponse, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
    }
}
