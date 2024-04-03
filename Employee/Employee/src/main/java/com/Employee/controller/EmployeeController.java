package com.Employee.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.exception.ResourceNotFoundException;
import com.Employee.entity.Employee;
import com.Employee.service.EmployeeService;


@RestController
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/emp/save")
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/emp")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
	}

	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) throws ResourceNotFoundException {
		return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}

	@PutMapping("/emp/save/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@PathVariable int id, @Valid @RequestBody Employee employee)
			throws ResourceNotFoundException {
		return new ResponseEntity<>(employeeService.updateEmployeeById(id, employee), HttpStatus.CREATED);
	}

	@DeleteMapping("/emp/delete/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public String deleteEmployeeById(@PathVariable int id) throws ResourceNotFoundException {
		return employeeService.deleteEmployeeById(id);
	}

}
