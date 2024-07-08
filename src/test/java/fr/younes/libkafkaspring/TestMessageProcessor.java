package fr.younes.libkafkaspring;

import fr.younes.libkafkaspring.processor.MessageProcessor;

public class TestMessageProcessor implements MessageProcessor<String,String> {

    @Override
    public void process1(String message) {
        System.out.println("Test processing message: " + message);
    }
    @Override
    public void process2(String message) {
        System.out.println("Test processing message: " + message);
    }
}
