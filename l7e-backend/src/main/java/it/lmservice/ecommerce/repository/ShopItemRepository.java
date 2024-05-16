package it.lmservice.ecommerce.repository;

import it.lmservice.ecommerce.entity.ShopItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopItemRepository extends JpaRepository<ShopItemEntity, Long> {
}