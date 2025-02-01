
# Spring Boot Kafka Example

This project demonstrates how to integrate **Spring Boot** with **Kafka** to produce and consume both `String` and `JSON` messages.

## Table of Contents

- [Overview](#overview)
- [Technologies](#technologies)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Application](#running-the-application)
- [Endpoints](#endpoints)
- [Producer](#producer)
- [Consumer](#consumer)
- [Contributing](#contributing)

## Overview

This project is a **Spring Boot** application that uses **Apache Kafka** as a message broker. It allows you to:

- Send **String** and **JSON** messages to a Kafka topic.
- Consume **String** and **JSON** messages from Kafka topics.
- Produce and consume **Person** objects as JSON messages.
- Demonstrates how to configure Kafka consumers and producers in Spring Boot.

The Kafka producer can send messages of two types:
1. **String messages** (e.g., a simple string message)
2. **JSON messages** (e.g., a serialized `Person` object)

The Kafka consumer listens to the corresponding topics and processes both `String` and `JSON` messages.

## Technologies

- **Spring Boot** (v2.x)
- **Apache Kafka** (v3.x)
- **Lombok** for boilerplate code reduction
- **Spring Kafka** for Kafka integration
- **Logback** for logging

## Installation

### Prerequisites

Before running the application, ensure you have the following installed:

- **JDK 17+**
- **Apache Kafka** (locally or on a remote server)
- **Zookeeper** (if running Kafka locally)

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/springboot-kafka-example.git
cd springboot-kafka-example
```

### 2. Build the Project

Using **Maven** or **Gradle**, build the project:

**For Maven:**
```bash
mvn clean install
```

**For Gradle:**
```bash
./gradlew build
```

### 3. Run Kafka (if running locally)

If Kafka and Zookeeper are not yet running, you can start them using the following commands:

```bash
# Start Zookeeper (if needed)
zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties

# Start Kafka broker
kafka-server-start /usr/local/etc/kafka/server.properties
```

Make sure Kafka is running on `localhost:9092`.

## Configuration

Kafka configuration can be modified via `application.yml` (or `application.properties`) file.

### `application.yml`

```yaml
server:
  port: 8081

spring:
  kafka:
    bootstrap-servers: localhost:9092
    consumer:
      group-id: groupOne
      auto-offset-reset: earliest
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.springframework.kafka.support.serializer.JsonDeserializer
      properties:
        spring.json.trusted.packages: "*"  # Allows deserialization of all packages
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
    topic:
      name: javaguides  # Specify the topic name
```

## Running the Application

### 1. Start the Spring Boot Application

Run the Spring Boot application using your IDE or through the command line:

```bash
mvn spring-boot:run
```

### 2. Send a String or JSON Message

Use any HTTP client (e.g., Postman, Curl) to test the application.

- **Send a string message:**

```bash
GET http://localhost:8081/api/v1/person/send?message=HelloKafka
```

- **Send a random Person object (JSON message):**

```bash
GET http://localhost:8081/api/v1/person/send
```

The `send` endpoint generates a random `Person` object with the fields:
- `name`
- `age`
- `email`

## Endpoints

- **`GET /api/v1/person`**
  - Returns a simple message: "This works!"
  
- **`GET /api/v1/person/send`**
  - Sends a random `Person` object as a JSON message to the Kafka topic `person`.

## Producer

The **KafkaProducer** class is responsible for sending messages to the Kafka topics. It can send both `String` messages and `Person` objects (as JSON).

- **sendMessage(String message):** Sends a plain `String` message.
- **sendPerson(Person person):** Sends a `Person` object as a JSON message.

## Consumer

The **KafkaConsumer** class listens to Kafka topics and processes both `String` and `Person` messages.

- **consume(String message):** Listens to messages in the `javaguides` topic and logs them.
- **consumePerson(Person person):** Listens to messages in the `person` topic and logs the `Person` details.

### Command to Listen to Events if Kafka Downloaded using Homebrew

```bash
/opt/homebrew/opt/kafka/bin/kafka-console-consumer --topic javaguides --from-beginning --bootstrap-server localhost:9092
```
