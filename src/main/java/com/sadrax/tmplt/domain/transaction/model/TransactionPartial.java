package com.sadrax.tmplt.domain.transaction.model;

import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@Value
public class TransactionPartial {
  String client;
  BigDecimal price;
}
