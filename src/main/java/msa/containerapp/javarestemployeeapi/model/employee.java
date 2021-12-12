package msa.containerapp.javarestemployeeapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class employee {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String department;
	private String phone;

	public employee(Integer id, String firstName, String lastName, String email, String department, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.department = department;
		this.phone = phone;
	}
}
