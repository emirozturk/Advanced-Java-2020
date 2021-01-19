package com.emirozturk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.core.SpringSecurityCoreVersion;

@SpringBootApplication
public class UygulamaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UygulamaApplication.class, args);
	}

}
