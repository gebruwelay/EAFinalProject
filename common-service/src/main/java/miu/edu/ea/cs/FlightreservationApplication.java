package miu.edu.ea.cs;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//import miu.cs544.project.flightreservation.controller.AirportController;
//import miu.cs544.project.flightreservation.controller.FlightController;
//import miu.cs544.project.flightreservation.controller.PassangerController;
//import miu.cs544.project.flightreservation.controller.ReservationController;
//import miu.cs544.project.flightreservation.controller.TicketController;
//import miu.cs544.project.flightreservation.controller.UserController;
import miu.edu.ea.cs.model.Role;
import miu.edu.ea.cs.model.User;
import miu.edu.ea.cs.service.UserService;

@SpringBootApplication
//@EnableSwagger2
public class FlightreservationApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FlightreservationApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    @Bean
    CommandLineRunner run (UserService userService){
        return args -> {
            userService.saveRole(new Role(null, "Role_Customer"));
            userService.saveRole(new Role(null, "Role_Agent"));
            userService.saveRole(new Role(null, "Role_Admin"));

            userService.saveUser(new User( "john", "pass", true, new ArrayList<>()));
            userService.saveUser(new User("smith", "pass", true, new ArrayList<>()));
            userService.saveUser(new User( "jim", "pass", true, new ArrayList<>()));
            userService.saveUser(new User( "admin", "123", true, new ArrayList<>()));
            userService.saveUser(new User( "agent", "123", true, new ArrayList<>()));


            userService.addRole("john", "Role_User");
            userService.addRole("smith", "Role_Agent");
            userService.addRole("jim", "Role_Admin");
            userService.addRole("jim", "Role_Agent");
            userService.addRole("admin", "Role_Admin");
            userService.addRole("admin", "Role_User");
            userService.addRole("agent", "Role_Agent");
        };
    }
 }
