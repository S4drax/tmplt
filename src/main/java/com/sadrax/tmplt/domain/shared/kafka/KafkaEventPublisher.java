package com.sadrax.tmplt.domain.shared.kafka;

import com.google.protobuf.GeneratedMessageV3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaEventPublisher {

  private static final String KAFKA_PRODUCER = "kafka_producer";
  private static final String CONTENT_TYPE_HEADER = "contentType";
  private static final String FORMAT_PROTO = "proto3";
  private final KafkaTemplate<String, byte[]> kafkaTemplate;

  @Value("${spring.application.name}")
  private String applicationName;

  public void publish(String topicName, GeneratedMessageV3 payload) {
    publish(topicName, payload, null);
  }

  public void publish(String topicName, GeneratedMessageV3 payload, @Nullable String extClassName) {
    log.info("Publishing message {} to {}", payload.toString(), topicName);
    kafkaTemplate.send(getRecord(topicName, payload, extClassName));
  }

  public void publish(String topicName, String key, GeneratedMessageV3 payload) {
    publish(topicName, key, payload, null);
  }

  public void publish(String topicName, String key, GeneratedMessageV3 payload, @Nullable String extClassName) {
    log.info("Publishing message {} to key {} on {}", payload.toString(), key, topicName);
    kafkaTemplate.send(getRecord(topicName, key, payload, extClassName));
  }

  private ProducerRecord<String, byte[]> getRecord(
      String topicName, GeneratedMessageV3 payload, @Nullable String extClassName) {
    ProducerRecord<String, byte[]> record = new ProducerRecord<String, byte[]>(topicName, payload.toByteArray());
    record.headers().add(KafkaHeaders.TOPIC, topicName.getBytes(StandardCharsets.UTF_8));
    record
        .headers()
        .add(
            KAFKA_PRODUCER,
            Optional.ofNullable(applicationName)
                .orElse("advisory-engine")
                .getBytes(StandardCharsets.UTF_8));
    Optional.ofNullable(extClassName)
        .ifPresent(
            clazz ->
                record
                    .headers()
                    .add(
                        CONTENT_TYPE_HEADER,
                        ("application/vnd." + clazz + "+" + FORMAT_PROTO)
                            .getBytes(StandardCharsets.UTF_8)));
    return record;
  }

  private ProducerRecord<String, byte[]> getRecord(
      String topicName, String key, GeneratedMessageV3 payload, @Nullable String extClassName) {
    ProducerRecord<String, byte[]> record = getRecord(topicName, payload, extClassName);
    record.headers().add(KafkaHeaders.KEY, key.getBytes(StandardCharsets.UTF_8));
    return record;
  }
}
