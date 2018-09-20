package com.building.controller.configuration;

import com.building.controller.conversion.ApplicationUserToApplicationUserDtoConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new ApplicationUserToApplicationUserDtoConverter());
    }
}
