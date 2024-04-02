package com.sadrax.tmplt.domain.transaction;

import com.sadrax.tmplt.domain.transaction.model.Transaction;
import com.sadrax.tmplt.domain.transaction.model.TransactionItem;
import com.sadrax.tmplt.domain.transaction.model.TransactionPartial;
import com.sadrax.tmplt.domain.transaction.model.TransactionStatus;
import com.sadrax.tmplt.infrastructure.transaction.kafka.TransactionKafkaPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Month;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DomainTransactionService implements TransactionService {

  private final TransactionRepository transactionRepository;
  private final TransactionKafkaPublisher transactionKafkaPublisher;

  @Override
  @Transactional(readOnly = true)
  public List<TransactionPartial> getTransactionList() {
    return transactionRepository.getTransactionList();
  }

  @Override
  @Transactional(readOnly = true)
  public Transaction getTransaction(UUID transactionId) {
    return transactionRepository.getTransaction(transactionId);
  }

  @Override
  @Transactional
  public void startTransaction(UUID clientId, List<TransactionItem> transactionItems) {
    transactionRepository.startTransaction(clientId, transactionItems);
  }

  @Override
  public void updateTransactionStatus(UUID transactionId, TransactionStatus status) {
    transactionKafkaPublisher.publishUpdateTransactionStatus(transactionId, status);
  }

  @Override
  @Transactional
  public void asyncUpdateTransactionStatus(UUID transactionId, TransactionStatus status) {
    transactionRepository.updateTransactionStatus(transactionId, status);
  }

  @Override
  @Transactional(readOnly = true)
  public void generateMontlyReport(Month month) {
    transactionRepository.generateMontlyReport(month);
  }

}
