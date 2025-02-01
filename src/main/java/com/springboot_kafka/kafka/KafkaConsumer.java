package com.springboot_kafka.kafka;

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

}
