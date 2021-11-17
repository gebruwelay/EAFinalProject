package edu.miu.ea.rs;

import edu.miu.ea.rs.model.Role;
import edu.miu.ea.rs.model.User;
import edu.miu.ea.rs.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Optional;


@SpringBootApplication
public class FlightReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightReservationApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    @Bean
    CommandLineRunner run (UserService userService) {
        return args -> {
            Optional<User> user = Optional.ofNullable(userService.getUser("john"));
            if(!user.isPresent()) {
                userService.saveRole(new Role(null, "Role_Customer"));
                userService.saveRole(new Role(null, "Role_Agent"));
                userService.saveRole(new Role(null, "Role_Admin"));

                userService.saveUser(new User( "john", "pass", true, new ArrayList<>()));
                userService.saveUser(new User("smith", "pass", true, new ArrayList<>()));
                userService.saveUser(new User( "jim", "pass", true, new ArrayList<>()));
                userService.saveUser(new User( "admin", "123", true, new ArrayList<>()));
                userService.saveUser(new User( "agent", "123", true, new ArrayList<>()));


                userService.addRole("john", "Role_Customer");
                userService.addRole("smith", "Role_Agent");
                userService.addRole("jim", "Role_Admin");
                userService.addRole("jim", "Role_Agent");
                userService.addRole("admin", "Role_Admin");
                userService.addRole("admin", "Role_Customer");
                userService.addRole("agent", "Role_Agent");
            }
        };
    }
 }
