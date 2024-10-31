package com.contract_manegement.business.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BusinessManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessManagementApplication.class, args);
	}

}
