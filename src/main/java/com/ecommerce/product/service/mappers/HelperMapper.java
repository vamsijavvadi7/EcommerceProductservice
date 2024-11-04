package com.ecommerce.product.service.mappers;

import com.ecommerce.product.dto.ProductCategoryDTO;
import com.ecommerce.product.model.ProductCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface HelperMapper {

    //custom mapping syntax
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "products", ignore = true),
    })
    ProductCategory toEntity(ProductCategoryDTO dto);
}
