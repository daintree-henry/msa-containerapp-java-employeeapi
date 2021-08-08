package msa.containerapp.javarestemployeeapi;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import msa.containerapp.javarestemployeeapi.dao.EmployeeDAO;
import msa.containerapp.javarestemployeeapi.model.employee;

public class EmployeeDAOTests {
	
	private EmployeeDAO employeeDao;
	
	@Before()
	public void setup () {
		this.employeeDao = new EmployeeDAO();
	}
	
	private void assertEmployeeSame (employee employee1, employee employee2) {
		Assert.assertTrue(employee1 != null && employee2 !=null);
		Assert.assertTrue(employee1.getFirstName().contentEquals(employee2.getFirstName()));
		Assert.assertTrue(employee1.getLastName().contentEquals(employee2.getLastName()));
		Assert.assertTrue(employee1.getEmail().contentEquals(employee2.getEmail()));
	}	
	
	@Test()
	public void findEmployeeTest () {
		employee employee = new employee(2, "sojung", "choi", "bluestar@gmail.com", "sales", "010-3124-3124");
		Optional<employee> foundEmployee = employeeDao.findEmployee(2);
		Assert.assertTrue(foundEmployee.isPresent());
		assertEmployeeSame(foundEmployee.get(),employee);
	}
	
	@Test()
	public void addEmployeeTest () {
		employee employee = new employee(0, "sojung", "choi", "bluestar@gmail.com", "sales", "010-3124-3124");
		int initialEmployeeCount = employeeDao.getAllEmployees().size();
		employeeDao.addEmployee(employee);
		int finalEmployeeCount = employeeDao.getAllEmployees().size();
		Assert.assertTrue(finalEmployeeCount == initialEmployeeCount + 1);
		Optional<employee> foundEmployee = employeeDao.findEmployee(employee.getId());
		Assert.assertTrue(foundEmployee.isPresent());
		assertEmployeeSame(foundEmployee.get(),employee);	
	}
	
	@Test()
	public void deleteEmployeeTest () {
		int employeeId = 1;
		int initialEmployeeCount = employeeDao.getAllEmployees().size();
		employeeDao.deleteEmployee(employeeId);
		int finalEmployeeCount = employeeDao.getAllEmployees().size();
		Assert.assertTrue(finalEmployeeCount == initialEmployeeCount - 1);
		Optional<employee> foundEmployee = employeeDao.findEmployee(employeeId);
		Assert.assertTrue(!foundEmployee.isPresent());
	}	
}
