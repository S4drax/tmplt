package com.sadrax.tmplt.infrastructure.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.filter.ForwardedHeaderFilter;

@ConfigurationPropertiesScan(value = "com.sadrax.tmplt")
@ComponentScan(
    value = {"com.sadrax.tmplt"})
@EnableAspectJAutoProxy
@Configuration
public class ApplicationConfig {

  @Bean
  ForwardedHeaderFilter forwardedHeaderFilter() {
    return new ForwardedHeaderFilter();
  }

}
