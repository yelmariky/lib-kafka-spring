package fr.younes.libkafkaspring;

import fr.younes.libkafkaspring.processor.MessageProcessor;

public class TestMessageProcessor implements MessageProcessor<String> {

    @Override
    public void process(String message) {
        System.out.println("Test processing message: " + message);
    }
}
