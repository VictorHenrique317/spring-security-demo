package com.example.springsecurity.jwt;

import com.auth0.jwt.algorithms.Algorithm;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Getter @Setter
@Configuration
@NoArgsConstructor
@ConfigurationProperties(prefix = "application.jwt")
public class JwtConfig {
    private String authorizationHeader;
    private String secureKey;
    private String tokenPrefix;
    private int daysToTokenExpiration;

    @Bean
    public Algorithm secretKey(){
        return Algorithm.HMAC256(secureKey);
    }
}
