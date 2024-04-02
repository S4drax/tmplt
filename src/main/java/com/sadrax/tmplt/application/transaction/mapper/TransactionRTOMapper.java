package com.sadrax.tmplt.application.transaction.mapper;

import com.sadrax.application.transaction.rto.TransactionItemRTO;
import com.sadrax.application.transaction.rto.TransactionPartialRTO;
import com.sadrax.application.transaction.rto.TransactionRTO;
import com.sadrax.tmplt.domain.transaction.model.Transaction;
import com.sadrax.tmplt.domain.transaction.model.TransactionItem;
import com.sadrax.tmplt.domain.transaction.model.TransactionPartial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TransactionRTOMapper {

  @Mapping(target = "productName", source = "product")
  TransactionItem mapItemToDomain(TransactionItemRTO transactionItemRTO);

  TransactionPartialRTO mapTransactionPartialToResponse(TransactionPartial partial);

  TransactionRTO mapTransactionToResponse(Transaction transaction);
}
