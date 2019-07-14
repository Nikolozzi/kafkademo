package com.gmail.khitirinikoloz.kafkademo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("Consumed Message(from topic -> users): " + message + " - " + "From partition: " + partition);
    }

    @KafkaListener(topics = "admins", groupId = "group_id")
    public void consume2(String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        logger.info("Consumed Message(from topic -> admins): " + message + " - " + "From partition: " + partition);
    }
}
