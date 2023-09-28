package com.rdi.cmsystem.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateCustomerDetailsRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;
    private String address;
}
