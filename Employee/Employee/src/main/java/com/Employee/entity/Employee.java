package com.Employee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "employees")
public class Employee {
	@Id	
	@GeneratedValue
	private int Id;
	@NotEmpty(message = "First name required")
	private String firstName;
	@NotEmpty(message = "Last name required")
	private String lastName;
	@NotEmpty(message = "Company name required")
	private String companyName;
	@NotEmpty(message = "Position name required")
	private String positionName;
	@Min(1)
	@Column(name = "salaryPackage")
	private int salaryPackage;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
	public int getSalaryPackage() {
		return salaryPackage;
	}
	public void setSalaryPackage(int salaryPackage) {
		this.salaryPackage = salaryPackage;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", companyName="
				+ companyName + ", positionName=" + positionName + ", salaryPackage=" + salaryPackage + "]";
	}
}
