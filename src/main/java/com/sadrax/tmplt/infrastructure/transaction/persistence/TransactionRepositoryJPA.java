package com.sadrax.tmplt.infrastructure.transaction.persistence;

import com.sadrax.tmplt.infrastructure.entity.generated.TransactionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepositoryJPA extends JpaRepository<TransactionsEntity, UUID> {
}
