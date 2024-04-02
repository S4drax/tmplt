package com.sadrax.tmplt.infrastructure.transaction.mapper;

import com.sadrax.tmplt.domain.transaction.model.TransactionItem;
import com.sadrax.tmplt.domain.transaction.model.TransactionStatus;
import com.sadrax.tmplt.infrastructure.entity.generated.ClientsEntity;
import com.sadrax.tmplt.infrastructure.entity.generated.ProductsEntity;
import com.sadrax.tmplt.infrastructure.entity.generated.TransactionItemsEntity;
import com.sadrax.tmplt.infrastructure.entity.generated.TransactionsEntity;
import com.sadrax.tmplt.proto.UpdateTransactionStatus;
import org.mapstruct.Mapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Mapper(imports = LocalDateTime.class)
public interface TransactionEntityMapper {

  default UpdateTransactionStatus mapToUpdateEvent(UUID transactionId, TransactionStatus status) {
    final UpdateTransactionStatus.TansactionStatus tansactionStatus =
        switch (status) {
          case STARTED -> UpdateTransactionStatus.TansactionStatus.STARTED;
          case PENDING -> UpdateTransactionStatus.TansactionStatus.PENDING;
          case CANCELLED -> UpdateTransactionStatus.TansactionStatus.CANCELLED;
          case PROCESSING -> UpdateTransactionStatus.TansactionStatus.PROCESSING;
          case FINISHED -> UpdateTransactionStatus.TansactionStatus.FINISHED;
        };
    return UpdateTransactionStatus.newBuilder()
        .setTransactionStatus(tansactionStatus)
        .setTransactionId(transactionId.toString())
        .build();
  }


  default TransactionsEntity mapTransactionToEntity(ClientsEntity client, BigDecimal totalPrice, String currency, LocalDateTime createDate) {
    return TransactionsEntity.builder()
        .status(TransactionStatus.STARTED.toString())
        .clientsEntity(client)
        .totalPrice(totalPrice)
        .currency(currency)
        .createDate(createDate)
        .createUser("USER") //TODO: Set after auth can load user login
        .build();
  }

  default TransactionItemsEntity mapItemToEntity(TransactionItem transactionItem, TransactionsEntity transactionsEntity, ProductsEntity productsEntity, LocalDateTime createDate) {
    return TransactionItemsEntity.builder()
        .transactionsEntity(transactionsEntity)
        .productsEntity(productsEntity)
        .currency(transactionItem.getCurrency())
        .buyPrice(transactionItem.getBuyPrice())
        .createDate(createDate)
        .createUser("USER")
        .build();
  }
}
