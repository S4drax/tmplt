package com.sadrax.tmplt.infrastructure.product.persistence;

import com.sadrax.tmplt.infrastructure.entity.generated.ProductsEntity;
import com.sadrax.tmplt.infrastructure.product.service.ProductPartialProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepositoryJPA extends JpaRepository<ProductsEntity, UUID> {

  @Query("""
    SELECT pe.name as name,
        pa.stock as stock,
        pa.price as price
    FROM ProductsEntity pe
    LEFT JOIN AvailabilityEntity pa ON pa.productId = pe.productId
    WHERE (:producent is null OR pe.producentsEntity.name = :producent)
    AND (:category is null OR pe.dictionaryEntity.code = :category)
    """)
  List<ProductPartialProjection> findProductPartialByFilters(String producent, String category);


  @Query("""
    SELECT pe
    FROM ProductsEntity pe
    WHERE pe.name in :productNames
  """)
  List<ProductsEntity> findAllByName(List<String> productNames);
}
