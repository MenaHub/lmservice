package it.lmservice.ecommerce.controller;

import it.lmservice.ecommerce.controller.dto.UserEnquiryBean;
import it.lmservice.ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUserEnquiry")
    public ResponseEntity<?> createUserEnquiry(@Valid @RequestBody UserEnquiryBean userEnquiryBean) {
        userService.createUserEnquiry(userEnquiryBean);
        return ResponseEntity.ok().build();
    }
}
