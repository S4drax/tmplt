package com.sadrax.tmplt.infrastructure.transaction.service;

import com.sadrax.tmplt.domain.transaction.TransactionRepository;
import com.sadrax.tmplt.domain.transaction.model.Transaction;
import com.sadrax.tmplt.domain.transaction.model.TransactionItem;
import com.sadrax.tmplt.domain.transaction.model.TransactionPartial;
import com.sadrax.tmplt.domain.transaction.model.TransactionStatus;
import com.sadrax.tmplt.infrastructure.client.persistence.ClientRepositoryJPA;
import com.sadrax.tmplt.infrastructure.entity.generated.ClientsEntity;
import com.sadrax.tmplt.infrastructure.entity.generated.ProductsEntity;
import com.sadrax.tmplt.infrastructure.entity.generated.TransactionItemsEntity;
import com.sadrax.tmplt.infrastructure.entity.generated.TransactionsEntity;
import com.sadrax.tmplt.infrastructure.product.persistence.ProductRepositoryJPA;
import com.sadrax.tmplt.infrastructure.shared.exception.NotFoundException;
import com.sadrax.tmplt.infrastructure.shared.exception.WrongTransactionStatusException;
import com.sadrax.tmplt.infrastructure.transaction.mapper.TransactionEntityMapper;
import com.sadrax.tmplt.infrastructure.transaction.persistence.TransactionItemRepositoryJPA;
import com.sadrax.tmplt.infrastructure.transaction.persistence.TransactionRepositoryJPA;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionRepositoryAdapter implements TransactionRepository {

  private final TransactionRepositoryJPA transactionRepositoryJPA;
  private final TransactionItemRepositoryJPA transactionItemRepositoryJPA;
  private final ProductRepositoryJPA productRepositoryJPA;
  private final ClientRepositoryJPA clientRepositoryJPA;
  private final TransactionEntityMapper mapper;

  @Override
  public List<TransactionPartial> getTransactionList() {
    return Collections.emptyList();
  }

  @Override
  public Transaction getTransaction(UUID transactionId) {
    return Transaction.builder().build();
  }

  @Override
  public void startTransaction(UUID clientId, List<TransactionItem> transactionItems) {
    if (!transactionItems.isEmpty()) {
      LocalDateTime createDate = LocalDateTime.now();

      String currency = transactionItems.stream().findFirst().map(TransactionItem::getCurrency)
          .orElseThrow(() -> new NotFoundException("Transaction doesn't have "));

      //todo: can think of currency exchange later, maybe both spring scheduler and quartz for that
      BigDecimal totalPrice = transactionItems.stream()
          .map(TransactionItem::getBuyPrice)
          .reduce(BigDecimal.ZERO, BigDecimal::add);

      ClientsEntity client = clientRepositoryJPA.findById(clientId)
          .orElseThrow(() -> new NotFoundException("Client not found."));

      TransactionsEntity newTransaction =  transactionRepositoryJPA.saveAndFlush(mapper.mapTransactionToEntity(client, totalPrice, currency, createDate));

      List<String> productNames = transactionItems.stream()
          .map(TransactionItem::getProductName)
          .toList();

      Map<String, ProductsEntity> productsNameMap = productRepositoryJPA.findAllByName(productNames).stream()
          .collect(Collectors.toMap(ProductsEntity::getName, Function.identity()));

      List<TransactionItemsEntity> newTransactionItems = transactionItems.stream()
          .map(item -> mapper.mapItemToEntity(item, newTransaction, productsNameMap.get(item.getProductName()), createDate))
          .toList();

      transactionItemRepositoryJPA.saveAllAndFlush(newTransactionItems);
    } else {
      throw new NotFoundException("Transaction items cannot be empty");
    }
  }

  @Override
  public void updateTransactionStatus(UUID transactionId, TransactionStatus status) {
    TransactionsEntity transaction = transactionRepositoryJPA.findById(transactionId)
        .orElseThrow(() -> new NotFoundException("Transaction with id %s not found.".formatted(transactionId.toString())));
    switch (transaction.getStatus()) {
      case ("FINISHED"):
      case ("CANCELLED"):
        throw new WrongTransactionStatusException("Transaction with id %s cannot have status changed, it already has been finalised".formatted(transactionId.toString()));
      default:
        transaction.setStatus(status.toString());
        transaction.setUpdateDate(LocalDateTime.now());
        transaction.setUpdateUser("CURRENT_USER"); //TODO: Set after auth can load user login
        transactionRepositoryJPA.save(transaction);
    }
  }

  @Override
  public void generateMontlyReport(Month month) {

  }
}
