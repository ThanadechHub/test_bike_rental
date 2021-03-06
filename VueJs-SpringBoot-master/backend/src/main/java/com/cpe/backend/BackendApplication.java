package com.cpe.backend;

// import com.cpe.backend.entity.Customer;
// import com.cpe.backend.entity.Employee;
// import com.cpe.backend.entity.RentalType;
// import com.cpe.backend.entity.Video;
// import com.cpe.backend.repository.CustomerRepository;
// import com.cpe.backend.repository.EmployeeRepository;
// import com.cpe.backend.repository.RentalTypeRepository;
// import com.cpe.backend.repository.VideoRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

import javax.servlet.Registration;

import com.cpe.backend.entity.Register;
import com.cpe.backend.entity.Gender;
import com.cpe.backend.entity.Bike;

import com.cpe.backend.repository.BikeRepository;
import com.cpe.backend.repository.GenderRepository;
import com.cpe.backend.repository.RegisterRepository;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	ApplicationRunner init(/*CustomerRepository customerRepository, EmployeeRepository employeeRepository,
						  RentalTypeRepository rentalTypeRepository, VideoRepository videoRepository*/
							 RegisterRepository registerRepository, GenderRepository genderRepository,
							 BikeRepository bikeRepository) {
		return args -> {

			Gender gender1 = new Gender();
			gender1.setName("ชาย");
			gender1.setGenderDescription("ผู้ชาย");
			genderRepository.save(gender1);

			Gender gender2 = new Gender();
			gender2.setName("หญิง");
			gender2.setGenderDescription("ผู้หญิง");
			genderRepository.save(gender2);
			
			Stream.of("CB650", "CBR650", "CBR1000", "CB1100").forEach(title -> {
			Bike bike = new Bike(); // สร้าง Object Customer
			bike.setTitle(title); // set ชื่อ (name) ให้ Object ชื่อ Customer
			bikeRepository.save(bike); // บันทึก Objcet ชื่อ Customer
			});



			// 	customerRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน Terminal
		};

	}

  }

		// 	Stream.of("Takoonkan", "Sitthichai", "Somchai", "Tanapon").forEach(name -> {
		// 		Customer customer = new Customer(); // สร้าง Object Customer
		// 		customer.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
		// 		customerRepository.save(customer); // บันทึก Objcet ชื่อ Customer
		// 	});

		// 	Stream.of("Ailada", "Lalita", "Atitaya", "Pongsatorn").forEach(name -> {
		// 		Employee employee = new Employee(); // สร้าง Object Employee
		// 		employee.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Employee
		// 		employeeRepository.save(employee); // บันทึก Objcet ชื่อ Employee
		// 	});

		// 	Stream.of("Daily", "Weekly", "Monthly").forEach(name -> {
		// 		RentalType rentalType = new RentalType(); // สร้าง Object Customer
		// 		rentalType.setName(name); // set ชื่อ (name) ให้ Object ชื่อ Customer
		// 		rentalTypeRepository.save(rentalType); // บันทึก Objcet ชื่อ Customer
		// 	});

		// 	Stream.of("Avengers: Endgame", "Wonder Woman", "Spider-Man: Far from Home").forEach(title -> {
		// 		Video video = new Video(); // สร้าง Object Video
		// 		video.setTitle(title); // set ชื่อ (name) ให้ Object ชื่อ Video
		// 		videoRepository.save(video); // บันทึก Objcet ชื่อ Video
		// 	});

		// 	customerRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Customer บน Terminal
		// 	employeeRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Employee บน Terminal
		// 	rentalTypeRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity RentalType บน Terminal
		// 	videoRepository.findAll().forEach(System.out::println); // แสดง ข้อมูลทั้งหมดใน Entity Video บน Terminal
		// };
