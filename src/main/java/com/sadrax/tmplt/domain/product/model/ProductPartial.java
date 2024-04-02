package com.sadrax.tmplt.domain.product.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@Value
public class ProductPartial {
  String name;
  Integer stock;
  BigDecimal price;
}
