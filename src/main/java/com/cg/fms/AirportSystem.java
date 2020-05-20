package com.cg.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.cg.fms.dao")
public class AirportSystem {

public static void main(String[] args) {
SpringApplication.run(AirportSystem.class, args);
}

}


