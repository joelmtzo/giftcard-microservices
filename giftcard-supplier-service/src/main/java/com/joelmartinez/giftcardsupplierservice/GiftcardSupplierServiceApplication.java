package com.joelmartinez.giftcardsupplierservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GiftcardSupplierServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GiftcardSupplierServiceApplication.class, args);
	}

}
