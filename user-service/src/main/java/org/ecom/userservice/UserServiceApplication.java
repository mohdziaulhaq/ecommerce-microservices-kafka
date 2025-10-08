package org.ecom.userservice;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

@SpringBootApplication
public class UserServiceApplication {
    @Autowired
    private Environment env;

    public static void main(String[] args) {

        SpringApplication.run(UserServiceApplication.class, args);

//        SpringApplication app = new SpringApplication(UserServiceApplication.class);
//
//        // CRITICAL FIX: Set the profile programmatically
//        app.setAdditionalProfiles("dev");
//
//        app.run(args);
    }

    @PostConstruct
    public void printActiveProfile() {
        System.out.println("Active profile(s): " + Arrays.toString(env.getActiveProfiles()));
    }

}
