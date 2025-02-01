package com.springboot_kafka.dummyobjects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

    private String name;

    private Integer age;

    private String email;

}
