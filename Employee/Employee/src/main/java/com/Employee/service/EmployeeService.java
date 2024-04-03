package com.Employee.service;

import java.util.List;

import com.Employee.entity.Employee;
import com.Employee.exception.ResourceNotFoundException;


public interface EmployeeService {
	Employee createEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(int id) throws ResourceNotFoundException;
    Employee updateEmployeeById(int id,Employee employee) throws ResourceNotFoundException;
    String deleteEmployeeById(int id) throws ResourceNotFoundException;

}
