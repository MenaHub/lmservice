package it.lmservice.ecommerce.repository;

import it.lmservice.ecommerce.entity.UserEnquiryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEnquiryRepository extends JpaRepository<UserEnquiryEntity, Long> {
}