package com.springboot_kafka.controller;

import com.springboot_kafka.dummyobjects.Person;
import com.springboot_kafka.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/person")
public class PersonController {

    private final KafkaProducer kafkaProducer;

    @GetMapping(path = "/send")
    public ResponseEntity<Person> sendPerson() {
        // Creates a dummy Person and sends it to Kafka Queue
        Random random = new Random();
        Person person = Person.builder()
                .name(STR."User-\{UUID.randomUUID().toString().substring(0, 5)}") // Generates a random name
                .age(random.nextInt(100)) // Random age between 0-99
                .email(STR."user\{random.nextInt(1000)}@example.com") // Random email
                .build();
        kafkaProducer.sendPerson(person);
        return ResponseEntity.ok(person);
    }

}
