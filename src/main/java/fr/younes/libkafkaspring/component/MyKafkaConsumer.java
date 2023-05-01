package fr.younes.libkafkaspring.component;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.kafka.support.Acknowledgment;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.younes.libkafkaspring.processor.MessageProcessor;

@ConditionalOnProperty(name="my.kafka.consumer.enabled",havingValue = "true")
@Component
public class MyKafkaConsumer {

     final MessageProcessor messageProcessor;
     
     private static final Logger log = LoggerFactory.getLogger(MyKafkaConsumer.class);

    // private final Tracer tracer;

/**
    public MyKafkaConsumer( MessageProcessor messageProcessor,Tracer tracer) {

        this.messageProcessor = messageProcessor;
       // this.tracer = tracer;
    }
***/
    public MyKafkaConsumer( MessageProcessor messageProcessor) {

        this.messageProcessor = messageProcessor;
       // this.tracer = tracer;
    }

    @KafkaListener(topics = "${my.kafka.consumer.topic}", groupId = "${my.kafka.consumer.groupId}")
    public void consumeMessage(String message, Acknowledgment acknowledgment) {
       // Span span = this.tracer.nextSpan().name("on-message").start();
		//try (Tracer.SpanInScope ws = this.tracer.withSpan(span)) {
            try{
			log.info("Got message <{}>", message);
			//log.info("<ACCEPTANCE_TEST> <TRACE:{}> Hello from consumer", this.tracer.currentSpan().context().traceId());
            messageProcessor.process(message);
            // Le message a été traité avec succès, on envoie un acquittement à Kafka
            acknowledgment.acknowledge();
        } catch (Exception e) {
            System.err.println("Erreur lors du traitement du message: " + e.getMessage());
            e.printStackTrace();
            // Dans ce cas, l'acquittement n'est pas envoyé, Kafka peut renvoyer le message ultérieurement
        }
	/** 	 finally {
			span.end();
		}**/
    }
       
            
    
}
