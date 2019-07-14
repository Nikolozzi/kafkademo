package com.gmail.khitirinikoloz.kafkademo.controllers;


import com.gmail.khitirinikoloz.kafkademo.services.Producer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class ProducerController {

    private final Producer producer;

    public ProducerController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message){
        producer.sendMessage(message);
    }
}
