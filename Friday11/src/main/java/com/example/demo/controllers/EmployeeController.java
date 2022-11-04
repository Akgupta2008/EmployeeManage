package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public String listEmployee(Model model) {
		model.addAttribute("employee", employeeService.getAllEmployees());
		return "employees";
	}
	
	@GetMapping("/employees/new")
	public String employeeName(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create-employee";
	}
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
	
	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit-employee";
	}
	
	@PostMapping("/employees/{id}")
	 public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model) {
		 
		 Employee existingEmployee = employeeService.getEmployeeById(id);
		 existingEmployee.setId(employee.getId());
		 existingEmployee.setFirstName(employee.getFirstName());
		 existingEmployee.setLastName(employee.getLastName());
		 existingEmployee.setEmail(employee.getEmail());
		 
		 employeeService.updateEmployee(existingEmployee);
		 
		 return "redirect:/employees";
	 }
	
	 @GetMapping("/employees/{id}")
	 public String deleteEmployee(@PathVariable Long id) {
		 employeeService.deleteEmployeeById(id);
		 return "redirect:/employees";
	 }
}
