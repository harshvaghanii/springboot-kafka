package com.springboot_kafka.kafka;

import com.springboot_kafka.dummyobjects.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, Person> personKafkaTemplate;

    public void sendMessage(String message) {
        log.info("Sent message: {}", message);
        kafkaTemplate.send("javaguides", message);
    }

    public void sendPerson(Person person) {
        log.info("Sending the details of the person: {}", person);
        personKafkaTemplate.send("person", person);
    }

}
