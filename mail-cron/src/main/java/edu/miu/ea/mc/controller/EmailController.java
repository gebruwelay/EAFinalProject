package edu.miu.ea.mc.controller;

import edu.miu.ea.mc.model.Email;
import edu.miu.ea.mc.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class EmailController {

    @Autowired
    private KafkaTemplate<String, Email> kafkaTemplate;
    @Autowired
    EmailService emailService;

    @GetMapping("/publish")
    public void publish(){
        Email email = new Email("okbithaile4@gmail.com", "test email","Hello" );
        emailService.publish(email);
    }
}
