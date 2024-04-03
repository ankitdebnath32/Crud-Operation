package com.Employee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.exception.ResourceNotFoundException;
import com.Employee.entity.Employee;
import com.Employee.Repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeImplementation implements EmployeeService {
    
    @Autowired
    public EmployeeRepository employeeRepository;
    
    public Employee createEmployee(Employee employee) {
        Employee employeeObj = employeeRepository.save(employee);
        return employeeObj;
    }
    
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
    
    public Employee getEmployeeById(int id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No employee found for this id : " + id));
        return employee;
    }
    
    public Employee updateEmployeeById(int id,Employee employee) throws ResourceNotFoundException{
        Employee employeeObj = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No employee found for this id : " + id));
        
        employeeObj.setFirstName(employee.getFirstName());
        employeeObj.setLastName(employee.getLastName());
        employeeObj.setCompanyName(employee.getCompanyName());
        employeeObj.setPositionName(employee.getPositionName());
        employeeObj.setSalaryPackage(employee.getSalaryPackage());
        
        Employee updatedemployeeObj = employeeRepository.save(employeeObj);
        return updatedemployeeObj;
    }
    
    public String deleteEmployeeDetailsById(int id) throws ResourceNotFoundException{
        Employee employeeDetails= employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cutomer not found for this id : " + id));
        employeeRepository.delete(employeeDetails);
        return "Deleted";
    }

	@Override
	public String deleteEmployeeById(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
    
}

