package com.hoony.msa;

import com.hoony.msa.springboot.repository.ICoffeeStatusMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@RequiredArgsConstructor
@EnableEurekaClient
@SpringBootApplication
public class MicroServiceApplication implements CommandLineRunner {
    private final ICoffeeStatusMapper iCoffeeStatusMapper;

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        iCoffeeStatusMapper.createStatusTable();
    }
}
