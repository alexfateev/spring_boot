package com.example.demo.config;

import com.example.demo.profile.DevProfile;
import com.example.demo.profile.ProductionProfile;
import com.example.demo.profile.SystemProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean
    @ConditionalOnProperty(prefix = "profile",
            name = "dev",
            havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(prefix = "profile",
            name = "prod",
            havingValue = "true")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
