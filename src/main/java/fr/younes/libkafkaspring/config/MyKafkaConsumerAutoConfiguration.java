package fr.younes.libkafkaspring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyKafkaConsumerAutoConfiguration {

    @Value("${my.kafka.consumer.topic}")
    private String topic;

    @Value("${my.kafka.consumer.group-id}")
    private String groupId;

    @Bean
    @ConditionalOnMissingBean
    public MyKafkaConsumer myKafkaConsumer() {
        return new MyKafkaConsumer(topic, groupId);
    }
}

