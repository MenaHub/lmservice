package it.lmservice.ecommerce.mapper;

import it.lmservice.ecommerce.controller.dto.UserEnquiryBean;
import it.lmservice.ecommerce.entity.UserEnquiryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserEnquiryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    UserEnquiryEntity toClientEnquiryEntity (UserEnquiryBean userEnquiryBean);
}
