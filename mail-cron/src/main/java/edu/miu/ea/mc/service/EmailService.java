package edu.miu.ea.mc.service;

import edu.miu.ea.mc.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private KafkaTemplate<String, Email> kafkaTemplate;

    private static final String TOPIC = "emailTopic";
    public void publish (Email email){
        kafkaTemplate.send(TOPIC, email);

    }

}
