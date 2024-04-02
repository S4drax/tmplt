package com.sadrax.tmplt.domain.product;

import com.sadrax.tmplt.domain.product.model.ProductPartial;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DomainProductService implements ProductService {


  private final ProductRepository productRepository;

  @Override
  @Transactional(readOnly = true)
  public List<ProductPartial> getProductList(String producent, String category) {
    return productRepository.getProductList(producent, category);
  }
}
