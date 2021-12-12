package msa.containerapp.javarestemployeeapi.model.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeePayload {

	String firstName;
	String lastName;
	String email;
	String department;
	String phone;

	public EmployeePayload(String firstName, String lastName, String email,String department,String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.department = department;
		this.phone = phone;
	}

}