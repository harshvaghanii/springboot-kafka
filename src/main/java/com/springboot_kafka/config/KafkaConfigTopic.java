package com.springboot_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfigTopic {

    @Value("${spring.kafka.topic.name}")
    private String stringTopicName;

    @Value("${spring.kafka.topic-json.name}")
    private String jsonTopicName;

    @Bean
    public NewTopic javaguidesTopic() {
        return TopicBuilder.name(stringTopicName)
                .build();
    }

    @Bean
    public NewTopic personTopic() {
        return TopicBuilder.name(jsonTopicName)
                .build();
    }

}
