package it.lmservice.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "client_enquiry")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEnquiryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "enquiry_subject", nullable = false)
    private String enquirySubject;

    @Column(name = "enquiry_body", nullable = false)
    private String enquiryBody;

}
