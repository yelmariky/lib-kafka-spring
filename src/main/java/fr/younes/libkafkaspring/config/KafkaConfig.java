package fr.younes.libkafkaspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"fr.younes.libkafkaspring"})
public class KafkaConfig {
    public KafkaConfig(){

    }
}