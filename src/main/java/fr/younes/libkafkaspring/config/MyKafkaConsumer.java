package fr.younes.libkafkaspring.config;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.kafka.support.Acknowledgment;

import fr.younes.libkafkaspring.processor.MessageProcessor;

@Component
public class MyKafkaConsumer {

     final MessageProcessor messageProcessor;


    public MyKafkaConsumer( MessageProcessor messageProcessor) {

        this.messageProcessor = messageProcessor;
    }

    @KafkaListener(topics = "${my.kafka.consumer.topic}", groupId = "${my.kafka.consumer.groupId}")
    public void consumeMessage(String message, Acknowledgment acknowledgment) {
        try {
            messageProcessor.process(message);
            // Le message a été traité avec succès, on envoie un acquittement à Kafka
            acknowledgment.acknowledge();
        } catch (Exception e) {
            System.err.println("Erreur lors du traitement du message: " + e.getMessage());
            e.printStackTrace();
            // Dans ce cas, l'acquittement n'est pas envoyé, Kafka peut renvoyer le message ultérieurement
        }
    }
}
