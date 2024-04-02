package com.sadrax.tmplt.domain.transaction.model;


import com.sadrax.application.transaction.rto.TransactionItemRTO;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
@Value
public class Transaction {
  UUID id;
  String client;
  TransactionStatus status;
  String currency;
  BigDecimal totalPrice;
  List<TransactionItemRTO> transactionItems;
}
