package com.sadrax.tmplt.application.product.rest;


import com.sadrax.application.product.api.ProductApi;
import com.sadrax.application.product.rto.ProductListFilterRTO;
import com.sadrax.application.product.rto.ProductPartialRTO;
import com.sadrax.tmplt.application.product.mapper.ProductRTOMapper;
import com.sadrax.tmplt.domain.product.ProductService;
import com.sadrax.tmplt.domain.product.model.ProductPartial;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController implements ProductApi {

  private final ProductService productService;
  private final ProductRTOMapper mapper;

  @Override
  //@PreAuthorize("hasAuthority('CAN_READ_PRODUCTS')")
  public ResponseEntity<List<ProductPartialRTO>> getProductList(ProductListFilterRTO productListFilterRTO) {
    List<ProductPartial> productPartials = productService.getProductList(productListFilterRTO.getProducent(), productListFilterRTO.getCategory());
    return ResponseEntity.ok(productPartials
        .stream()
        .map(mapper::mapProductPartialToRTO)
        .toList());
  }
}
