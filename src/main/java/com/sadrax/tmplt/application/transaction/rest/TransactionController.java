package com.sadrax.tmplt.application.transaction.rest;

import com.sadrax.application.transaction.api.TransactionApi;
import com.sadrax.application.transaction.rto.*;
import com.sadrax.tmplt.application.transaction.mapper.TransactionRTOMapper;
import com.sadrax.tmplt.domain.transaction.TransactionService;
import com.sadrax.tmplt.domain.transaction.model.Transaction;
import com.sadrax.tmplt.domain.transaction.model.TransactionPartial;
import com.sadrax.tmplt.domain.transaction.model.TransactionStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TransactionController implements TransactionApi {

  private final TransactionService transactionService;
  private final TransactionRTOMapper mapper;

  @Override
  public ResponseEntity<TransactionRTO> getTransaction(UUID id) {
    Transaction transaction = transactionService.getTransaction(id);
    return ResponseEntity.ok(mapper.mapTransactionToResponse(transaction));
  }

  @Override
  public ResponseEntity<List<TransactionPartialRTO>> getTransactionList(TransactionListFilterRTO transactionListFilterRTO) {
    List<TransactionPartial> partialList = transactionService.getTransactionList();
    return ResponseEntity.ok(partialList.stream().map(mapper::mapTransactionPartialToResponse).toList());
  }

  @Override
  public ResponseEntity<Void> startTransaction(StartTransactionRequestRTO startTransactionRequestRTO) {
    transactionService.startTransaction(startTransactionRequestRTO.getClient(),
        startTransactionRequestRTO.getTransactionItems().stream().map(mapper::mapItemToDomain).toList());
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  public ResponseEntity<Void> updateTransactionStatus(UUID id, UpdateTransactionStatusRequestRTO updateTransactionStatusRequestRTO) {
    transactionService.updateTransactionStatus(id, TransactionStatus.valueOf(updateTransactionStatusRequestRTO.getStatus()));
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
