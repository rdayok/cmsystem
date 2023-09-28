package com.rdi.cmsystem.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateCustomerDetailsResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;
    private String address;
}
