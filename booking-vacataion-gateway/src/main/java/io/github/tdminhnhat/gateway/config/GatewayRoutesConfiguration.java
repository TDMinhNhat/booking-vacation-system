package io.github.tdminhnhat.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfiguration {

    @Bean
    public RouteLocator configRouteLocators(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("location-service", r -> r.path("/location/**").uri("lb://location-service")).build();
    }
}
