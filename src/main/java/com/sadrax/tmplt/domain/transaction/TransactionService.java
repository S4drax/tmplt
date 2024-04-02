package com.sadrax.tmplt.domain.transaction;

import com.sadrax.tmplt.domain.transaction.model.Transaction;
import com.sadrax.tmplt.domain.transaction.model.TransactionItem;
import com.sadrax.tmplt.domain.transaction.model.TransactionPartial;
import com.sadrax.tmplt.domain.transaction.model.TransactionStatus;

import java.time.Month;
import java.util.List;
import java.util.UUID;

public interface TransactionService {

  List<TransactionPartial> getTransactionList();

  Transaction getTransaction(UUID transactionId);

  void startTransaction(UUID clientId, List<TransactionItem> transactionItems);

  void updateTransactionStatus(UUID transactionId, TransactionStatus status);

  void asyncUpdateTransactionStatus(UUID transactionId, TransactionStatus status);

  void generateMontlyReport(Month month);
}
