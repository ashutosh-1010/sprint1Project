package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelBookingsManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingsManagementSystemApplication.class, args);
		System.out.println("......Connected to Database......");
	}

}
