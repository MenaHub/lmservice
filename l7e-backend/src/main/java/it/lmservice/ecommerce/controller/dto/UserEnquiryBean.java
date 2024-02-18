package it.lmservice.ecommerce.controller.dto;

import lombok.Data;

@Data
public class UserEnquiryBean{
private String fullName;
private String email;
private String enquirySubject;
private String enquiryBody;
}
