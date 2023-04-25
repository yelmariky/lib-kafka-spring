package fr.younes.libkafkaspring.processor;


public interface MessageProcessor {
    void process(String message);
}
