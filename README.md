# Real-Time Wikimedia Data Processing with Kafka and MySQL

This project streams real-time Wikimedia changes from the [Wikimedia Event Stream](https://stream.wikimedia.org/v2/stream/recentchange) using Kafka. The data is then consumed and stored in a MySQL database.

## Project Overview

The project consists of two main modules: 
1. **Producer**: - Uses `EventSource` to listen for real-time changes from the Wikimedia stream. - Processes each change event in `WikimediaHandler`. - Sends the event data to a Kafka topic called `wikimedia`.
2. **Consumer**: - Consumes the event data from the `wikimedia` Kafka topic. - Stores the processed data in a MySQL database.

## Prerequisites

Before you begin, ensure you have the following installed: - Apache Kafka - Zookeeper (included with Kafka) - MySQL Database - Java 8 or above - Maven

## Steps to Start Zookeeper, Broker, and Kafka Topic

### 1. Start Zookeeper

Kafka relies on Zookeeper, so you must start it first.

```bash # Go to your Kafka directory cd kafka_2.13-2.7.0 # Start Zookeeper on the default port 2181 bin/zookeeper-server-start.sh config/zookeeper.properties ```

### 2. Start Kafka Broker

Next, start the Kafka broker that listens for connections on port 9092.

```bash # In a new terminal, go to the Kafka directory cd kafka_2.13-2.7.0 # Start the Kafka broker bin/kafka-server-start.sh config/server.properties ```

### 3. Create Kafka Topic

Create a Kafka topic named `wikimedia` where your producer will send data.

```bash # In the Kafka directory, create the topic bin/kafka-topics.sh --create --topic wikimedia --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1 ```

### 4. Check the Created Topic

To verify that the `wikimedia` topic has been created:

```bash bin/kafka-topics.sh --list --bootstrap-server localhost:9092 ```

## Storing Data in MySQL

The consumer module is responsible for saving the event data into a MySQL database. To ensure correct storage:

1. Ensure MySQL is running.
2. Update the MySQL database connection details in the `application.properties` file in the `consumer` module.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/wikimedia
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

