package com.sadrax.tmplt.application.product.mapper;

import com.sadrax.application.product.rto.ProductPartialRTO;
import com.sadrax.tmplt.domain.product.model.ProductPartial;
import org.mapstruct.Mapper;

@Mapper()
public interface ProductRTOMapper {

  ProductPartialRTO mapProductPartialToRTO(ProductPartial projection);
}
