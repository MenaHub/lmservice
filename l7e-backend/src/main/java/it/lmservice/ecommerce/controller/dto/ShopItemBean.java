package it.lmservice.ecommerce.controller.dto;

import lombok.Data;

@Data
public class ShopItemBean {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String imagePath;
    private String category;
    private String material;
}
