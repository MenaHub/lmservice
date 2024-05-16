package it.lmservice.ecommerce.mapper;

import it.lmservice.ecommerce.controller.dto.ShopItemBean;
import it.lmservice.ecommerce.entity.ShopItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ShopItemMapper {

    ShopItemBean toShopItemBean(ShopItemEntity shopItemEntity);

    //ShopItemEntity toShopItemEntity(ShopItemBean shopItemBean);

}
