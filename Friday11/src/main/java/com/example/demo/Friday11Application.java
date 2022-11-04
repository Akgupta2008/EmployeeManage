package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repositories.EmployeeRepository;

@SpringBootApplication
public class Friday11Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Friday11Application.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello");
	}
}
