package edu.miu.ea.rs.service;

import edu.miu.ea.rs.model.Email;
import edu.miu.ea.rs.model.Passenger;
import edu.miu.ea.rs.repository.PassangerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CronService {

    @Autowired
    private KafkaTemplate<String, Email> kafkaTemplate;

    @Autowired
    PassangerRepository passangerRepository;
    private static final String TOPIC = "emailTopic3";


    @Scheduled(cron="*/5 * * * * MON-FRI")
    public void publish (){
        List<Passenger> passengers = passangerRepository.findEmail();
        passengers.stream()
                .map(Passenger::getEmail)
                .map(email -> new Email("lulitm5489@gmail.com", "","Your flight is in 24 hours"))
                .forEach(e -> kafkaTemplate.send(TOPIC, e));

        System.out.println("passenger======================="+passengers);
    }
}
