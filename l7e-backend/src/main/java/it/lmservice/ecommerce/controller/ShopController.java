package it.lmservice.ecommerce.controller;

import it.lmservice.ecommerce.controller.dto.ShopItemBean;
import it.lmservice.ecommerce.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/get-items")
    public List<ShopItemBean> getItems() {
        return shopService.getShopItems();
    }
}
