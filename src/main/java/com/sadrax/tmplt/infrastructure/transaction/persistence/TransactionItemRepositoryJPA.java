package com.sadrax.tmplt.infrastructure.transaction.persistence;

import com.sadrax.tmplt.infrastructure.entity.generated.TransactionItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionItemRepositoryJPA extends JpaRepository<TransactionItemsEntity, UUID> {
}
