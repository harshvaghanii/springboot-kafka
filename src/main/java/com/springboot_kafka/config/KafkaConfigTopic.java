package com.springboot_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfigTopic {

    @Bean
    public NewTopic javaguidesTopic() {
        return TopicBuilder.name("javaguides")
                .build();
    }

    @Bean
    public NewTopic personTopic() {
        return TopicBuilder.name("person")
                .build();
    }

}
