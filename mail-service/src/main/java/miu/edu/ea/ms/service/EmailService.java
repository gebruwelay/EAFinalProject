package miu.edu.ea.ms.service;

import miu.edu.ea.ms.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(Email email){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("cs544.project@gmail.com");
        simpleMailMessage.setTo(email.getAddress());
        simpleMailMessage.setText(email.getBody());
        simpleMailMessage.setSubject(email.getSubject());
        mailSender.send(simpleMailMessage);
        System.out.println("mail sent successfully");
    }
}
