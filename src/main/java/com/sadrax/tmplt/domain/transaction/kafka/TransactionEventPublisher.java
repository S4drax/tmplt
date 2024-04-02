package com.sadrax.tmplt.domain.transaction.kafka;

import com.sadrax.tmplt.domain.transaction.model.TransactionStatus;

import java.util.UUID;

public interface TransactionEventPublisher {
  void publishUpdateTransactionStatus(UUID transactionId, TransactionStatus status);

}
