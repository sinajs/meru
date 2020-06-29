package com.meru.productdetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductDetailsServiceApplication{


	public static void main(String[] args) {
		SpringApplication.run(ProductDetailsServiceApplication.class, args);
		
	}
	
	
	}
