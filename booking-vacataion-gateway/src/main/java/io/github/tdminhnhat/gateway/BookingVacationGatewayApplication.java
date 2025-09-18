package io.github.tdminhnhat.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookingVacationGatewayApplication {

    static void main(String[] args) {
        SpringApplication.run(BookingVacationGatewayApplication.class, args);
    }

}
