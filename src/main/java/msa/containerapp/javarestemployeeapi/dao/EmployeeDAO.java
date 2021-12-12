package msa.containerapp.javarestemployeeapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import msa.containerapp.javarestemployeeapi.model.employee;
import msa.containerapp.javarestemployeeapi.model.employees;
 
@Repository
public class EmployeeDAO {
	private static employees list = new employees();

	static {
		list.getEmployeeList().add(new employee(1, "hyeongyu", "lee", "daintree-henry@gmail.com", "tech", "010-1234-1234"));
		list.getEmployeeList().add(new employee(2, "sojung", "choi", "bluestar@gmail.com", "sales", "010-3124-3124"));
		list.getEmployeeList().add(new employee(3, "junghun", "kim", "kjh@gmail.com", "hr", "010-4212-4222"));
	}

	public List<employee> getAllEmployees() {
		return list.getEmployeeList();
	}

	public void addEmployee(employee employee) {
		employee.setId(list.getEmployeeList().size()+1);
		list.getEmployeeList().add(employee);
	}

	public boolean deleteEmployee(int id) {
		List<employee> employeeList = list.getEmployeeList();
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getId() == id) {
				employeeList.remove(i);
				return true;
			}
		}
		return false;
	}

	public Optional<employee> findEmployee(int id) {
		List<employee> employeeList = list.getEmployeeList();
		employee employee;
		for (int i = 0; i < employeeList.size(); i++) {
			employee = employeeList.get(i);
			if (employee.getId() == id) {
				return Optional.of(employee);
			}
		}
		return Optional.empty();
	}

	public Boolean validateEmployee(int id) {
		List<employee> employeeList = list.getEmployeeList();
		employee employee;
		for (int i = 0; i < employeeList.size(); i++) {
			employee = employeeList.get(i);
			if (employee.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public Integer findLastId() {
		List<employee> employeeList = list.getEmployeeList();
		int lastId = 0;
		for (int i = 0; i < employeeList.size(); i++) {
			int id = employeeList.get(i).getId();
			if (lastId < id) {
				lastId = id;
			}
		}
		return lastId;
	}
}
