package com.sadrax.tmplt.infrastructure.product.service;

import java.math.BigDecimal;

public interface ProductPartialProjection {
  String getName();
  Integer getStock();
  BigDecimal getPrice();

}
