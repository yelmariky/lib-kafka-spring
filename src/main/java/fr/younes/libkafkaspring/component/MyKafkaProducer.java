package fr.younes.libkafkaspring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@ConditionalOnProperty(name="my.kafka.producer.enabled",havingValue = "true")
@Service
public class MyKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MyKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String key, String value) {
        kafkaTemplate.send(topic, key, value);
    }

    public void sendMessage(String topic, String value) {
        kafkaTemplate.send(topic, value);
    }

   
}
