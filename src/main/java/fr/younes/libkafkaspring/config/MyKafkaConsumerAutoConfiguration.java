package fr.younes.libkafkaspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.younes.libkafkaspring.component.MyKafkaConsumer;
import fr.younes.libkafkaspring.processor.MessageProcessor;

@Configuration
public class MyKafkaConsumerAutoConfiguration {

    @Value("${my.kafka.consumer.topic}")
    private String topic;

    @Value("${my.kafka.consumer.group-id}")
    private String groupId;

    @Autowired
    private MessageProcessor messageProcessor;

    @Bean
    public MyKafkaConsumerConfig myKafkaConsumerConfig() {
        return new MyKafkaConsumerConfig(topic, groupId);
    }

    @Bean
    @ConditionalOnMissingBean
    public MyKafkaConsumer myKafkaConsumer(MyKafkaConsumerConfig config, MessageProcessor messageProcessor) {
        return new MyKafkaConsumer(config, messageProcessor);
    }
}


