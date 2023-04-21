package fr.younes.libkafkaspring;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TestConfiguration.class})
public class MyKafkaConsumerTest {

    @Test
    public void testConsumeMessage() {
        assertTrue(true);
    }
}

