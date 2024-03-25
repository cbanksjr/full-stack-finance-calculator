package com.financecalculator.financecalculator.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    protected ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
