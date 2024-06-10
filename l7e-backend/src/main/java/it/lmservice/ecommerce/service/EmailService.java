package it.lmservice.ecommerce.service;

import it.lmservice.ecommerce.entity.EmailEntity;
import it.lmservice.ecommerce.repository.EmailRepository;
import lombok.extern.slf4j.Slf4j;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.email.EmailBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Slf4j
public class EmailService {

    @Autowired
    private Mailer mailer;

    @Autowired
    private EmailRepository emailRepository;

    @Transactional
    public void sendEmail(EmailEntity email) {
        log.info("Sending email to: {}", email.getToAddress());
        Email e = EmailBuilder.startingBlank()
                .from(email.getFromAddress())
                .to(email.getToAddress())
                .withSubject(email.getSubject())
                .withPlainText(email.getBody())
                .buildEmail();

        try {
            mailer.sendMail(e);
            email.setSentDate(LocalDateTime.now());
        } catch (Exception ex) {
            log.error("Unable to send email", ex);
            email.setFailCount(email.getFailCount() + 1);
            email.setReadyDate(LocalDateTime.now().plusMinutes(2));
        }
    }

    @Transactional
    public void saveEmail(EmailEntity email) {
        emailRepository.save(email);
    }
}
