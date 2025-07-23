package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return service.createEmployee(employee);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping
	public List<Employee> getAll(){
		return service.getAll();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping("/{id}")
	public Employee getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
	  @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
	@GetMapping("/{name}")
	public Employee getByName(@PathVariable String name) {
		return service.getByName(name);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}
}
