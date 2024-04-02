package com.sadrax.tmplt.infrastructure.product.service;

import com.sadrax.tmplt.domain.product.ProductRepository;
import com.sadrax.tmplt.domain.product.model.ProductPartial;
import com.sadrax.tmplt.infrastructure.product.mapper.ProductEntityMapper;
import com.sadrax.tmplt.infrastructure.product.persistence.ProductRepositoryJPA;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductRepositoryAdapter implements ProductRepository {

  private final ProductRepositoryJPA productRepositoryJPA;
  private final ProductEntityMapper mapper;

  @Override
  public List<ProductPartial> getProductList(String producent, String category) {
    return productRepositoryJPA.findProductPartialByFilters(producent, category)
        .stream()
        .map(mapper::mapProductPartialToDomain)
        .toList();
  }
}
