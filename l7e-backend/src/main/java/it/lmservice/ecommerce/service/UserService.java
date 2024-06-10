package it.lmservice.ecommerce.service;

import it.lmservice.ecommerce.controller.dto.UserEnquiryBean;
import it.lmservice.ecommerce.entity.EmailEntity;
import it.lmservice.ecommerce.entity.UserEnquiryEntity;
import it.lmservice.ecommerce.repository.UserEnquiryRepository;
import it.lmservice.ecommerce.mapper.UserEnquiryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class UserService {

    @Autowired
    private UserEnquiryMapper userEnquiryMapper;
    @Autowired
    private UserEnquiryRepository userEnquiryRepository;
    @Autowired
    private EmailService emailService;

    @Transactional
    public void createUserEnquiry(UserEnquiryBean userEnquiryBean) {
        UserEnquiryEntity userEnquiryEntity = userEnquiryMapper.toClientEnquiryEntity(userEnquiryBean);
        userEnquiryEntity.setCreatedAt(LocalDateTime.now());
        userEnquiryRepository.save(userEnquiryEntity);
        EmailEntity email = EmailEntity.builder()
                .toAddress("receiver@email.com")
                .fromAddress(userEnquiryBean.getEmail())
                .subject(userEnquiryEntity.getEnquirySubject())
                .body(userEnquiryEntity.getEnquiryBody())
                .build();
        emailService.saveEmail(email);

        emailService.sendEmail(email);
    }
}
