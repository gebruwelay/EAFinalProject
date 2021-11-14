package miu.edu.ea.ms;

import miu.edu.ea.ms.model.Email;
import miu.edu.ea.ms.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Application {
@Autowired
    EmailService emailService;
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
