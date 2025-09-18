package io.github.tdminhnhat.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BookingVacationServerApplication {

    static void main(String[] args) {
        SpringApplication.run(BookingVacationServerApplication.class, args);
    }

}
