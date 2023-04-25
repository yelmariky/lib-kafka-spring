package fr.younes.libkafkaspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import fr.younes.libkafkaspring.component.MyKafkaConsumer;
import fr.younes.libkafkaspring.processor.MessageProcessor;

@ConditionalOnProperty(name="my.kafka.consumer.enabled",havingValue = "true")
@Configuration
public class MyKafkaConsumerAutoConfiguration {


    @Autowired
    private MessageProcessor messageProcessor;

    @Bean
    @ConditionalOnMissingBean
    public MyKafkaConsumer myKafkaConsumer( MessageProcessor messageProcessor) {
        return new MyKafkaConsumer( messageProcessor);
    }
}


