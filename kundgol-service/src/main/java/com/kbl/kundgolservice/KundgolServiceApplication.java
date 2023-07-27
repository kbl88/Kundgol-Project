package com.kbl.kundgolservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.kbl.kundgolservice.dto"})
public class KundgolServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KundgolServiceApplication.class, args);
	}

}
