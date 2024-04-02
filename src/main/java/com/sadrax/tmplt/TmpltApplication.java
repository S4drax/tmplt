package com.sadrax.tmplt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(scanBasePackages = {
		"com.sadrax.tmplt"
})
@EntityScan(basePackages = { "com.sadrax.tmplt.infrastructure.entity.generated" })
@ConfigurationPropertiesScan(basePackages = {"com.sadrax.tmplt"})
public class TmpltApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmpltApplication.class, args);
	}

}
