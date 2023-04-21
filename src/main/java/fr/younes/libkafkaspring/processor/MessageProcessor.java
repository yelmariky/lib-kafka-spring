package fr.younes.libkafkaspring.processor;

import org.springframework.stereotype.Service;


public interface MessageProcessor {
    void process(String message);
}
