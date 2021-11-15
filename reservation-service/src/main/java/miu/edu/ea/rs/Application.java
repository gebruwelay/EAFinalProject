package miu.edu.ea.rs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "miu.edu.ea.cs")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
