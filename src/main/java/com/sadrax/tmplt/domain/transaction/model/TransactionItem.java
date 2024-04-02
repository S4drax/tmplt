package com.sadrax.tmplt.domain.transaction.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Value
public class TransactionItem {
  UUID id;
  String productName;
  BigDecimal buyPrice;
  String currency;
}
