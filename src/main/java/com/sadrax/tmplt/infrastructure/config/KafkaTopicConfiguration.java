package com.sadrax.tmplt.infrastructure.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "tmplt.kafka.topic")
@Data
public class KafkaTopicConfiguration {
    private String updateTransactionStatus;
}
