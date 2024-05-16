package it.lmservice.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "shop_item")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "image_path", nullable = false)
    private String imagePath;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "material", nullable = false)
    private String material;

    // TODO: evaluate if these attributes make sense
//    @Column(name = "item_rating")
//    private Double itemRating;
//
//    @Column(name = "item_discount")
//    private Double itemDiscount;
//
//    @Column(name = "item_discount_price")
//    private Double itemDiscountPrice;
//
//    @Column(name = "item_discount_percentage")
//    private Double itemDiscountPercentage;
//
//    @Column(name = "item_discount_start_date")
//    private String itemDiscountStartDate;
//
//    @Column(name = "item_discount_end_date")
//    private String itemDiscountEndDate;
//
//    @Column(name = "item_discount_status")
//    private String itemDiscountStatus;
//
//    @Column(name = "item_status", nullable = false)
//    private String itemStatus;
//
//    @Column(name = "item_deleted", nullable = false)
//    private String itemDeleted;
//
//    @Column(name = "item_deleted_date", nullable = false)
//    private String itemDeletedDate;
//
//    @Column(name = "item_deleted_reason", nullable = false)
//    private String itemDeletedReason;

}