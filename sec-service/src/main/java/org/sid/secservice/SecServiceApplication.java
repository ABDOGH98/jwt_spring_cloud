package org.sid.secservice;

import org.sid.secservice.Entities.AppRole;
import org.sid.secservice.Entities.AppUser;
import org.sid.secservice.Service.AcountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SecServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner start(AcountService acountService){
        return args -> {
            acountService.addNewRole(new AppRole(null,"user"));
            acountService.addNewRole(new AppRole(null,"admin"));
            acountService.addNewRole(new AppRole(null,"customer_manager"));
            acountService.addNewRole(new AppRole(null,"product_manager"));
            acountService.addNewRole(new AppRole(null,"bills_manager"));

            acountService.addNewUser(new AppUser(null,"user1","123",new ArrayList<>()));
            acountService.addNewUser(new AppUser(null,"user2","123",new ArrayList<>()));
            acountService.addNewUser(new AppUser(null,"user3","123",new ArrayList<>()));
            acountService.addNewUser(new AppUser(null,"user4","123",new ArrayList<>()));
            acountService.addNewUser(new AppUser(null,"admin","123",new ArrayList<>()));

            acountService.addRoleToUser("user1","user");
            acountService.addRoleToUser("admin","admin");
            acountService.addRoleToUser("admin","user");
            acountService.addRoleToUser("user2","customer_manager");
            acountService.addRoleToUser("user2","user");
            acountService.addRoleToUser("user3","product_manager");
            acountService.addRoleToUser("user3","user");
            acountService.addRoleToUser("user4","bills_manager");
            acountService.addRoleToUser("user4","user");



        };
    }

}
