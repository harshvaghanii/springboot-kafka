package com.springboot_kafka.kafka;

import com.springboot_kafka.dummyobjects.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {


    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.groupId}")
    public void consume(String message) {
        log.info("This is the message: {}", message);
    }

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.groupId}")
    public void consumePerson(Person person) {
        log.info("This is the person sent by Kafka: {} ", person);
    }

}
