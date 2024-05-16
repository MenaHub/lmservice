package it.lmservice.ecommerce.service;

import it.lmservice.ecommerce.controller.dto.ShopItemBean;
import it.lmservice.ecommerce.entity.ShopItemEntity;
import it.lmservice.ecommerce.mapper.ShopItemMapper;
import it.lmservice.ecommerce.repository.ShopItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    private ShopItemRepository shopItemRepository;

    @Autowired
    private ShopItemMapper shopItemMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addShopItem(String name, String category, String material, String description, double price, String imagePath) {
        ShopItemEntity shopItemEntity = ShopItemEntity.builder()
                .name(name)
                .category(category)
                .material(material)
                .description(description)
                .price(price)
                .imagePath(imagePath)
                .quantity(0)
                .build();

        shopItemRepository.save(shopItemEntity);
    }

    @Transactional
    public List<ShopItemBean> getShopItems() {
        return shopItemRepository.findAll().stream().map(item -> shopItemMapper.toShopItemBean(item)).toList();
    }
}
