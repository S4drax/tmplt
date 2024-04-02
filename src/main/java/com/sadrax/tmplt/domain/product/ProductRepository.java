package com.sadrax.tmplt.domain.product;

import com.sadrax.tmplt.domain.product.model.ProductPartial;

import java.util.List;

public interface ProductRepository {

  /**
   * Gets filtered list of partial products
   *
   * @param producent producent filter
   * @param category category filter
   *
   * @return List<ProductPartial>
   */
  List<ProductPartial> getProductList(String producent, String category);

}
