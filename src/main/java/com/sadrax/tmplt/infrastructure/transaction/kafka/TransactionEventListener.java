package com.sadrax.tmplt.infrastructure.transaction.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import com.sadrax.tmplt.domain.transaction.TransactionService;
import com.sadrax.tmplt.proto.UpdateTransactionStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransactionEventListener {

  private final TransactionService transactionService;

  @KafkaListener(
      topics = "${tmplt.kafka.topic.update-transaction-status}",
      groupId = "#{T(java.util.UUID).randomUUID().toString()}")
  public void handleUpdateStatus(final ConsumerRecord<String, byte[]> event) throws InvalidProtocolBufferException {
    log.info("Received update status event");
    final UpdateTransactionStatus eventContent = UpdateTransactionStatus.parseFrom(event.value());
  }
}
