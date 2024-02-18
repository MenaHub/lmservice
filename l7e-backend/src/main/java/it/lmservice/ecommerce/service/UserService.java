package it.lmservice.ecommerce.service;

import it.lmservice.ecommerce.controller.dto.UserEnquiryBean;
import it.lmservice.ecommerce.entity.UserEnquiryEntity;
import it.lmservice.ecommerce.repository.UserEnquiryEntityRepository;
import it.lmservice.ecommerce.mapper.UserEnquiryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserEnquiryMapper userEnquiryMapper;
    @Autowired
    private UserEnquiryEntityRepository userEnquiryEntityRepository;

    @Transactional
    public void createUserEnquiry(UserEnquiryBean userEnquiryBean) {
        //TODO: save user enquiry to database
        UserEnquiryEntity userEnquiryEntity = userEnquiryMapper.toClientEnquiryEntity(userEnquiryBean);
        userEnquiryEntityRepository.save(userEnquiryEntity);
        //TODO: send email to admin
    }
}
