package com.example.employee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Employee createEmployee(Employee employee) {
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
	    return repo.save(employee);
	}
	
	public List<Employee> getAll(){
		return repo.findAll();
	}
	
	public Employee getById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Employee getByName(String name) {
		return repo.findByUsername(name);
	}
	
	public void deleteById(Long id) {
		repo.deleteById(id);
	}
	
	

}
