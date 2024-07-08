package fr.younes.libkafkaspring.config.consumer;

import fr.younes.libkafkaspring.config.consumer.KafkaConsumerService;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.config.MethodKafkaListenerEndpoint;
import org.springframework.kafka.listener.MessageListener;

import org.springframework.kafka.support.Acknowledgment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class DynamicKafkaListenerConfig {

    @Autowired
    private Environment env;

    @Autowired
    private ConcurrentKafkaListenerContainerFactory<String, Object> factory;

    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @Autowired
    private KafkaConsumerService kafkaConsumerService;

    @Bean
    public void setupKafkaListeners() throws NoSuchMethodException {
        List<String> topics = Stream.of(env.getProperty("app.kafka.topics").split(",")).collect(Collectors.toList());
        List<String> groupIds = Stream.of(env.getProperty("app.kafka.group-ids").split(",")).collect(Collectors.toList());

        for (int i = 0; i < topics.size(); i++) {
            String topic = topics.get(i);
            String groupId = groupIds.get(i);
            registerKafkaListener(topic, groupId, i + 1);
        }
    }

    private void registerKafkaListener(String topic, String groupId, int index) throws NoSuchMethodException {
        MethodKafkaListenerEndpoint<String, Object> endpoint = new MethodKafkaListenerEndpoint<>();
        endpoint.setId(topic + "-" + groupId);
        endpoint.setGroupId(groupId);
        endpoint.setTopics(topic);

        endpoint.setBean(kafkaConsumerService);
        endpoint.setMethod(KafkaConsumerService.class.getDeclaredMethod("processMessage" + index, ConsumerRecord.class, Acknowledgment.class));

        kafkaListenerEndpointRegistry.registerListenerContainer(endpoint, factory, true);
    }
}
