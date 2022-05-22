package com.Comp.Comp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Comp.Repository.*;
import com.Comp.Model.*;

@SpringBootApplication
public class EmployeeManagement {

	private static final Logger log = LoggerFactory.getLogger(EmployeeManagement.class);

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagement.class, args);
	}

	@Bean
	public CommandLineRunner loadDatabase(EmployeeRepository repository) {
		return (args) -> {

			repository.save(new Employee("Dikshetha", "Manager", 5000000));
			repository.save(new Employee("Navya", "Developer", 200000));
			repository.save(new Employee("Ruchika", "HR", 50000));
			repository.save(new Employee("Harshitha", "Programmer", 50000));

			log.info("All Employees");
			log.info("-------------------------------");
			for (Employee employee : repository.findAll()) {
				log.info(employee.toString());
			}

			Employee employee = repository.findById(1L);
			log.info("Employee found with findById(1L):");
			log.info("--------------------------------");
			log.info(employee.toString());
		};
	}

}

