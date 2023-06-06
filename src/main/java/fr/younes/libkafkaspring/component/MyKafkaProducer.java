package fr.younes.libkafkaspring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@ConditionalOnProperty(name="my.kafka.producer.enabled",havingValue = "true")
@Service
public class MyKafkaProducer <T> {

    private final KafkaTemplate<String, T> kafkaTemplate;

    @Autowired
    public MyKafkaProducer(KafkaTemplate<String, T> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String key, T value) {
        kafkaTemplate.send(topic, key, value);
    }

    public void sendMessage(String topic, T value) {
        kafkaTemplate.send(topic, value);
    }

   
}
