package org.creation.gateway.config;


import org.creation.gateway.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }
}
