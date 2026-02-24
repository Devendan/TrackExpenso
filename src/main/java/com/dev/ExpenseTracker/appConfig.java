package com.dev.ExpenseTracker;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class appConfig {
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
