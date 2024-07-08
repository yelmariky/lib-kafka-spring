package fr.younes.libkafkaspring.processor;


public interface MessageProcessor<T1,T2> {
    void process1(T1 message);
    void process2(T2 message);
}
