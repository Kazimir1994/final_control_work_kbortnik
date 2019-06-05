package ru.kazimir.bornik.final_control_work_kbortnik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "ru.kazimir.bornik.final_control_work_kbortnik")
@EntityScan(basePackages = "ru.kazimir.bornik.final_control_work_kbortnik")
public class FinalControlWorkKbortnikApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinalControlWorkKbortnikApplication.class, args);
	}
}
