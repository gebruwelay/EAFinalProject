package miu.edu.ea.cs;

import edu.miu.ea.cm.Airport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        Airport a = new Airport();
        SpringApplication.run(Application.class, args);
    }


}
