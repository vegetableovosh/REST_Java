package com.vegetable.practice.controller;

import com.vegetable.practice.kafka.KafkaProducer;
import com.vegetable.practice.repository.CatRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final KafkaProducer kafkaProducer;
    private final CatRepository catRepository;

    public Controller(KafkaProducer kafkaProducer, CatRepository catRepository) {

        this.kafkaProducer = kafkaProducer;
        this.catRepository = catRepository;
    }

    @PostMapping("/kafka/send")
    public String send(@RequestParam int id) {
        var cat = catRepository.findById(id).orElseThrow();
        kafkaProducer.sendMessage(cat.toString());

        return "Success";
    }

}
