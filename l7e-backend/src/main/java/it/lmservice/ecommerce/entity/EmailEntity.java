package it.lmservice.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
public class EmailEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FROM_ADDRESS")
    private String fromAddress;

    @Column(name = "TO_ADDRESS")
    private String toAddress;

    @Column(name = "SUBJECT")
    private String subject;

    @Column(name = "BODY")
    private String body;

    @Column(name = "SENT_DATE")
    private LocalDateTime sentDate;

    @Column(name = "READY_DATE")
    private LocalDateTime readyDate;

    @Column(name = "FAIL_COUNT")
    private int failCount;

}
