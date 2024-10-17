# Real-Time Wikimedia Data Processing with Kafka and MySQL

This project streams real-time Wikimedia changes from the [Wikimedia Event Stream](https://stream.wikimedia.org/v2/stream/recentchange) using Kafka. The data is then consumed and stored in a MySQL database.

## Project Overview

The project consists of two main modules: 
1. **Producer**: - Uses `EventSource` to listen for real-time changes from the Wikimedia stream. - Processes each change event in `WikimediaHandler`. - Sends the event data to a Kafka topic called `wikimedia`.
2. **Consumer**: - Consumes the event data from the `wikimedia` Kafka topic. - Stores the processed data in a MySQL database.

## Prerequisites

Before you begin, ensure you have the following installed: - Apache Kafka - Zookeeper (included with Kafka) - MySQL Database - Java 8 or above - Maven

## Getting Started

These instructions will help you get a copy of the project running on your local machine.

### Prerequisites

- **Java 8+**: Ensure you have the latest version of Java installed.
- **Apache Kafka**: Download and install [Apache Kafka](https://kafka.apache.org/downloads).
- **Spring Boot**: The project uses Spring Boot to implement Kafka producers and consumers.

### Starting Zookeeper and Kafka Broker

1. **Start Zookeeper**: Navigate to your Kafka installation directory and start Zookeeper with the following command:

   ```bash
   bin/zookeeper-server-start.sh config/zookeeper.properties
   ```

2. **Start Kafka Broker**: After Zookeeper starts, launch Kafka Broker:

   ```bash
   bin/kafka-server-start.sh config/server.properties
   ```

### Creating Kafka Topics

To create Kafka topics for string and JSON data, use the following commands.

1. **Create a topic**:

   ```bash
   bin/kafka-topics.sh --create --topic wikimedia --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
   ```

## Storing Data in MySQL

The consumer module is responsible for saving the event data into a MySQL database. To ensure correct storage:

1. Ensure MySQL is running.
2. Update the MySQL database connection details in the `application.properties` file in the `consumer` module.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/wikimedia
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

