package it.lmservice.ecommerce.service;

import it.lmservice.ecommerce.repository.ShopItemRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
public class InitService {

    @Value("classpath:init/shop-items.yml")
    private Resource shopItemsResource;

    @Autowired
    private ShopItemRepository shopItemRepository;

    @Autowired
    private ShopService shopService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void initShopItems() throws IOException {
        if (shopItemRepository.count() > 0) {
            log.info("Shop items already initialized, skipping...");
            return;
        }

        Yaml yaml = new Yaml();
        DefaultShopItemsMap defaultShopItemsMap = yaml.loadAs(this.shopItemsResource.getInputStream(), DefaultShopItemsMap.class);
        if (defaultShopItemsMap.items == null) {
            return;
        }
        addShopItems(defaultShopItemsMap.items);
    }

    private void addShopItems(Map<String, DefaultShopItem> shopItemsMap) {
        shopItemsMap.forEach((key, value) -> {
            log.info("Adding shop item with key {}", key);
            shopService.addShopItem(value.getName(), value.getCategory(), value.getMaterial(), value.getDescription(), value.getPrice(), value.getImagePath());
        });
    }

    @Data
    public static class DefaultShopItemsMap {
        Map<String, DefaultShopItem> items;
    }

    @Data
    public static class DefaultShopItem {
        String name;
        String category;
        String material;
        String description;
        double price;
        String imagePath;
    }
}
