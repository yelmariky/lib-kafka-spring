package fr.younes.libkafkaspring.config;

public class MyKafkaConsumerConfig {

    private String topic;
    private String groupId;

    public MyKafkaConsumerConfig(String topic, String groupId) {
        this.topic = topic;
        this.groupId = groupId;
    }

    public String getTopic() {
        return topic;
    }

    public String getGroupId() {
        return groupId;
    }
}
