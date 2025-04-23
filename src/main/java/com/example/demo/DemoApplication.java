package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import jakarta.persistence.EntityManager;
import com.example.demo.Repository.FlightRepo;
import com.example.demo.Service.FlightService;

import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {
	// static public FlightRepo flightRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		// Lấy bean FlightRepo từ ApplicationContext
		// FlightService flightService = context.getBean(FlightService.class);

		// // Truy vấn và in kết quả
		// System.out.println("###########");

		// // Gọi phương thức service để lấy dữ liệu chuyến bay
		// flightService.getFlightByFromAndTo("HN", "HP").forEach(System.out::println);
	}
}
