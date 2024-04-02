package com.sadrax.tmplt.domain.product;

import com.sadrax.tmplt.domain.product.model.ProductPartial;

import java.util.List;

public interface ProductService {

    List<ProductPartial> getProductList(String producent, String category);
}
