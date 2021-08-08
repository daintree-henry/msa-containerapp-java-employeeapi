package msa.containerapp.javarestemployeeapi.model.rest;

public class EmployeePayload {

	String firstName;
	String lastName;
	String email;
	String department;
	String phone;
	
	public EmployeePayload(String firstName, String lastName, String email,String department,String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.department = department;
		this.phone = phone;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}
	
	public String getDepartment() {
		return department;
	}

	public String getPhone() {
		return phone;
	}

	@Override
	public String toString() {
		return "AssetPayload [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", department=" + department + ", phone=" + phone + "]";
	}
	
}