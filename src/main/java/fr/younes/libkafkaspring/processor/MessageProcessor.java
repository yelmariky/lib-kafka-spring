package fr.younes.libkafkaspring.processor;


public interface MessageProcessor<T> {
    void process(T message);
}
