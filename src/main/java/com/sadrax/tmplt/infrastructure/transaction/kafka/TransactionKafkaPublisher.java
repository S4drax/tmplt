package com.sadrax.tmplt.infrastructure.transaction.kafka;

import com.sadrax.tmplt.domain.shared.kafka.KafkaEventPublisher;
import com.sadrax.tmplt.domain.transaction.kafka.TransactionEventPublisher;
import com.sadrax.tmplt.domain.transaction.model.TransactionStatus;
import com.sadrax.tmplt.infrastructure.config.KafkaTopicConfiguration;
import com.sadrax.tmplt.infrastructure.transaction.mapper.TransactionEntityMapper;
import com.sadrax.tmplt.proto.UpdateTransactionStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class TransactionKafkaPublisher extends KafkaEventPublisher implements TransactionEventPublisher {
  private final KafkaTopicConfiguration kafkaTopicConfiguration;
  private final TransactionEntityMapper mapper;

  public TransactionKafkaPublisher(KafkaTemplate<String, byte[]> kafkaTemplate, KafkaTopicConfiguration kafkaTopicConfiguration, TransactionEntityMapper mapper) {
    super(kafkaTemplate);
    this.kafkaTopicConfiguration = kafkaTopicConfiguration;
    this.mapper = mapper;
  }

  @Override
  public void publishUpdateTransactionStatus(UUID transactionId, TransactionStatus status) {
    final UpdateTransactionStatus event = mapper.mapToUpdateEvent(transactionId, status);
    publish(kafkaTopicConfiguration.getUpdateTransactionStatus(), event);
  }


}
