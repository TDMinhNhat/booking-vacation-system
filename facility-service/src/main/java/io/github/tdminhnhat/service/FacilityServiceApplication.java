package io.github.tdminhnhat.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FacilityServiceApplication {

    static void main(String[] args) {
        SpringApplication.run(FacilityServiceApplication.class, args);
    }

}
