package com.sadrax.tmplt.infrastructure.product.mapper;

import com.sadrax.tmplt.domain.product.model.ProductPartial;
import com.sadrax.tmplt.infrastructure.product.service.ProductPartialProjection;
import org.mapstruct.Mapper;

@Mapper()
public interface ProductEntityMapper {

  ProductPartial mapProductPartialToDomain(ProductPartialProjection projection);
}
