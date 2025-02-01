package com.springboot_kafka.kafka;

import com.springboot_kafka.dummyobjects.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, Person> personKafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String jsonTopicName;

    public void sendMessage(String message) {
        log.info("Sent message: {}", message);
        kafkaTemplate.send(topicName, message);
    }

    public void sendPerson(Person person) {
        Message<Person> message = MessageBuilder
                .withPayload(person)
                .setHeader(KafkaHeaders.TOPIC, jsonTopicName)
                .build();
        log.info("This is the person in Message format: {}", message);
        kafkaTemplate.send(message);
    }

}
