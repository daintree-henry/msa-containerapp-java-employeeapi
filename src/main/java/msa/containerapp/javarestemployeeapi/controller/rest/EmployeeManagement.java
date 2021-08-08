package msa.containerapp.javarestemployeeapi.controller.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.annotations.ApiOperation;
import msa.containerapp.javarestemployeeapi.dao.EmployeeDAO;
import msa.containerapp.javarestemployeeapi.model.employee;
import msa.containerapp.javarestemployeeapi.model.employees;
import msa.containerapp.javarestemployeeapi.model.rest.EmployeePayload;
 
@RestController
@RequestMapping(path = "api/employees")
public class EmployeeManagement
{
	@Autowired
	private EmployeeDAO employeeDao;

	@ApiOperation(value = "Get JSON representation of a list of all employees")
	@GetMapping(path = "", produces = "application/json")
	public List<employee> getEmployees() {
		return employeeDao.getAllEmployees();
	}

	@ApiOperation(value = "Get JSON representation of a specified employee")
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<?> getEmployee(@PathVariable int id) {
		Optional<employee> foundEmployeeOptional = employeeDao.findEmployee(id);
		if (foundEmployeeOptional.isPresent()) {
			return new ResponseEntity<>(foundEmployeeOptional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Create a JSON specified employee")
	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody EmployeePayload employeePayload) {
		employee employee = new employee(0, employeePayload.getFirstName(), employeePayload.getLastName(), employeePayload.getEmail(), employeePayload.getDepartment(), employeePayload.getPhone());
		employeeDao.addEmployee(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId())
				.toUri();
		// in the location header of the response return the URL needed to access the
		// newly created employee and return HttpStatus.CREATED
		return ResponseEntity.created(location).build();
	}

	@ApiOperation(value = "Delete a specified employee")
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {
		if (employeeDao.deleteEmployee(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Update a specified employee")
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> updateEmployee(@RequestBody EmployeePayload employeePayload, @PathVariable int id) {
		Optional<employee> foundEmployeeOptional = employeeDao.findEmployee(id);
		if (foundEmployeeOptional.isPresent()) {
			employee foundEmployee = foundEmployeeOptional.get();
			if (employeePayload.getFirstName() != null)
				foundEmployee.setFirstName(employeePayload.getFirstName());
			if (employeePayload.getLastName() != null)
				foundEmployee.setLastName(employeePayload.getLastName());
			if (employeePayload.getEmail() != null)
				foundEmployee.setEmail(employeePayload.getEmail());
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
