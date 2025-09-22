package io.github.tdminhnhat.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"io.github.tdminhnhat"})
public class BookingServiceApplication {

    static void main(String[] args) {
        SpringApplication.run(BookingServiceApplication.class, args);
    }

}
