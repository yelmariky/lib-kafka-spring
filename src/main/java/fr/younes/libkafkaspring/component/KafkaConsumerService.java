package fr.younes.libkafkaspring.component;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService<T1, T2> {

    public void processMessage1(ConsumerRecord<String, T1> record, Acknowledgment acknowledgment) {
        try {
            // Traitement du message
            System.out.println("Processing message1 with key: " + record.key() + ", value: " + record.value());

            // Simuler un traitement réussi
            acknowledgment.acknowledge();
            System.out.println("Message1 acknowledged successfully.");
        } catch (Exception e) {
            System.err.println("Error processing message1: " + e.getMessage());
        }
    }

    public void processMessage2(ConsumerRecord<String, T2> record, Acknowledgment acknowledgment) {
        try {
            // Traitement du message
            System.out.println("Processing message2 with key: " + record.key() + ", value: " + record.value());

            // Simuler un traitement réussi
            acknowledgment.acknowledge();
            System.out.println("Message2 acknowledged successfully.");
        } catch (Exception e) {
            System.err.println("Error processing message2: " + e.getMessage());
        }
    }

    // Ajoutez d'autres méthodes processMessageN au besoin
}
