package com.gmail.khitirinikoloz.kafkademo.services;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger =
            LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users";
    private static final String TOPIC1 = "admins";

    @Bean
    public NewTopic topic1(){
        return new NewTopic(TOPIC,10, (short) 2);
    }

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        logger.info(String.format("Producing message: %s", message));
        kafkaTemplate.send(TOPIC,message);
        kafkaTemplate.send(TOPIC1, message);
    }

}
