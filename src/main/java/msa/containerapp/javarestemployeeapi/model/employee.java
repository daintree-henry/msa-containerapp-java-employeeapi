package msa.containerapp.javarestemployeeapi.model;

public class employee {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String department;
	private String phone;

	public employee() {

	}

	public employee(Integer id, String firstName, String lastName, String email, String department, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.department = department;
		this.phone = phone;
	}

	// Getters and setters

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Employee " + id + " Info --- firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", department=" + department + ", phone=" + phone;
	}
}
