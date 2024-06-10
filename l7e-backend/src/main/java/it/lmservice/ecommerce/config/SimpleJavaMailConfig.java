package it.lmservice.ecommerce.config;

import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleJavaMailConfig {

    @Value("${simplejavamail.smtp.host}")
    private String smtpHost;

    @Value("${simplejavamail.smtp.port}")
    private int smtpPort;

    @Value("${simplejavamail.javaxmail.debug}")
    private boolean debug;

    @Bean
    public Mailer mailer() {
        return MailerBuilder
                .withSMTPServer(smtpHost, smtpPort)
                .withDebugLogging(debug)
                .buildMailer();
    }
}
