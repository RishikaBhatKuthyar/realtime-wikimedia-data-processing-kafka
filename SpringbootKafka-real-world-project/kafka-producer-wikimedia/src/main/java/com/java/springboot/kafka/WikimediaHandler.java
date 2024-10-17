package com.java.springboot.kafka;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikimediaHandler implements EventHandler {

    private KafkaTemplate<String,String>kafkaTemplate;
    private String topic;
    private static final Logger LOGGER= LoggerFactory.getLogger(WikimediaHandler.class);
    public WikimediaHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void onOpen() throws Exception {
        LOGGER.info("Opened connection to Wikimedia stream.");

    }

    @Override
    public void onClosed() throws Exception {
        LOGGER.info("Closed connection to Wikimedia stream.");

    }
    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        LOGGER.info(String.format("event data->%s",messageEvent.getData()));
        //WikimediaHandler processes the event and sends the event data to the Kafka topic.
        kafkaTemplate.send(topic,messageEvent.getData());

    }

    @Override
    public void onComment(String s) throws Exception {
        LOGGER.info("Received comment: " + s);

    }

    @Override
    public void onError(Throwable throwable) {
        LOGGER.error("Error in Wikimedia stream: " + throwable.getMessage());

    }
}
