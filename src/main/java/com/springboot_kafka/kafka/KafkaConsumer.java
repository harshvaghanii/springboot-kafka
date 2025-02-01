package com.springboot_kafka.kafka;

import com.springboot_kafka.dummyobjects.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "javaguides", groupId = "groupOne")
    public void consume(String message) {
        log.info("This is the message: {}", message);
    }

    @KafkaListener(topics = "person", groupId = "groupOne")
    public void consumePerson(Person person) {
        log.info("This is the person sent by Kafka: {} ", person);
    }

}
