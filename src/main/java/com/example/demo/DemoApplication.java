package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import jakarta.persistence.EntityManager;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		// EntityManager entityManager = context.getBean(EntityManager.class);
		// entityManager.getTransaction().begin();
		// entityManager.getTransaction().commit();
		// entityManager.close();
		// context.close();
	}
}

// Lấy repository từ Spring context
// AirTrafficControllerRepository repository =
// context.getBean(AirTrafficControllerRepository.class);
// // AreaRepository areaRepository = context.getBean(AreaRepository.class);
// // Area a = areaRepository.findById("A01").orElse(null);
// // Lấy tất cả dữ liệu và in ra console
// System.out.println("Lấy tất cả các nhân viên điều khiển không lưu thông:");
// repository.findByIdArea("A01").forEach(controller -> {
// System.out.println(controller);
// });