package miu.edu.ea.cs;

import edu.miu.ea.cm.Airport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan("edu.miu.ea.cm")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        Airport a = new Airport();
        a.test();
        SpringApplication.run(Application.class, args);
    }


}
