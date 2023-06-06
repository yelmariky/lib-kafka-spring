package fr.younes.libkafkaspring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.younes.libkafkaspring.processor.MessageProcessor;

@Configuration
public class TestConfiguration {

    @Bean
    public MessageProcessor messageProcessor() {
        return new TestMessageProcessor();
    }
}
