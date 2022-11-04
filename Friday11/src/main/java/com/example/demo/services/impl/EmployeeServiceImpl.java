package com.example.demo.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
		private EmployeeRepository employeeRepository;

		public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
			this.employeeRepository = employeeRepository;
		}

		@Override
		public List<Employee> getAllEmployees() {
			return employeeRepository.findAll();
		}

		@Override
		public Employee saveEmployee(Employee employee) {
			return employeeRepository.save(employee);
		}

		@Override
		public Employee getEmployeeById(Long id) {
			return employeeRepository.findById(id).get();
		}

		@Override
		public Employee updateEmployee(Employee employee) {
			return employeeRepository.save(employee);
		}

		@Override
		public void deleteEmployeeById(Long id) {
			employeeRepository.deleteById(id);
		}
		
		
}
