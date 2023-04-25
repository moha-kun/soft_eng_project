package org.moha.miniproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniProjectApplication.class, args);
    }

    /*@Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Mohamed", "moha", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Ahmed", "ahmed", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Ali", "ali", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Khalid", "khalid", "1234", new ArrayList<>()));

            userService.addRoleToUser("moha", "ROLE_USER");
            userService.addRoleToUser("moha", "ROLE_MANAGER");
            userService.addRoleToUser("moha", "ROLE_ADMIN");
            userService.addRoleToUser("moha", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("ali", "ROLE_USER");
            userService.addRoleToUser("ali", "ROLE_MANAGER");
            userService.addRoleToUser("ali", "ROLE_ADMIN");
            userService.addRoleToUser("ahmed", "ROLE_USER");
            userService.addRoleToUser("ahmed", "ROLE_MANAGER");
            userService.addRoleToUser("khalid", "ROLE_USER");


        };
    }*/

}
