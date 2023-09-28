package com.rdi.cmsystem.services;

import com.rdi.cmsystem.data.models.Customer;
import com.rdi.cmsystem.dto.request.UpdateCustomerDetailsRequest;
import com.rdi.cmsystem.dto.response.CustomerResponse;
import com.rdi.cmsystem.dto.response.RegisterCustomerResponse;
import com.rdi.cmsystem.dto.request.RegisterCustomerRequest;
import com.rdi.cmsystem.dto.response.UpdateCustomerDetailsResponse;

import java.util.List;


public interface CustomerService {

    List<CustomerResponse> getCustomers();

    CustomerResponse getCustomer(Long customerId);

    void deleteCustomer(Long id);

    CustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerRequest);

    CustomerResponse updateCustomerDetails(UpdateCustomerDetailsRequest updateCustomerDetailsRequest);
}

