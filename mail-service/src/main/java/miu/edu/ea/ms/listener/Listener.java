package miu.edu.ea.ms.listener;

import miu.edu.ea.ms.model.Email;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Listener {
    @KafkaListener(topics = "email-new",groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
    @KafkaListener(topics = "email-new",groupId = "group_json", containerFactory = "emailKafkaListenerFactory")
    public void consume(Email email) {
        System.out.println("Consumed message: " + email);
    }
}
