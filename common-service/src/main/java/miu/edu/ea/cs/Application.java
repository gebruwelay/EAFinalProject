package miu.edu.ea.cs;

import edu.miu.ea.cm.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        Test a = new Test();
        SpringApplication.run(Application.class, args);
    }


}
