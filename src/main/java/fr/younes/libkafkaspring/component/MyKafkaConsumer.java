package fr.younes.libkafkaspring.component;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import fr.younes.libkafkaspring.config.MyKafkaConsumerConfig;
import fr.younes.libkafkaspring.processor.MessageProcessor;

@Component
public class MyKafkaConsumer {

    private final String topic;
    private final String groupId;
    private final MessageProcessor messageProcessor;

    public MyKafkaConsumer(MyKafkaConsumerConfig config, MessageProcessor messageProcessor) {
        this.topic = config.getTopic();
        this.groupId = config.getGroupId();
        this.messageProcessor = messageProcessor;
    }

    @KafkaListener(topics = "#{topic}", groupId = "#{groupId}")
    public void consumeMessage(String message) {
        System.out.println("Consumed message: " + message);
        messageProcessor.process(message);
    }
}
