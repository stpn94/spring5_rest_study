package spring5_rest_study.controller;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring5_rest_study.dto.Employee;
import spring5_rest_study.exception.DuplicateEmployeeException;
import spring5_rest_study.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/employees")
	public ResponseEntity<Object> employees() {
		System.out.println("employees()");
		return ResponseEntity.ok(service.getLists());
	}

	@GetMapping("/employees/{empNo}")
	public ResponseEntity<Object> Employee(@PathVariable int empNo, HttpServletResponse response) {
		Employee employee = service.getEmployee(empNo);
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(employee);
	}

	@PostMapping("/employees/")
	public ResponseEntity<Object> newEmployee(@RequestBody Employee employee) {
		System.out.println("newEmployee > " + employee);
		try {
			service.registerEmployee(employee);
			URI uri = URI.create("/api/employees/" + employee.getEmpNo());
			return ResponseEntity.created(uri).body(employee.getEmpNo());
			// return ResponseEntity.status(HttpStatus.CREATED).body(Employee.getId());
		} catch (DuplicateEmployeeException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

	@PatchMapping("/employees/{empNo}")
	public ResponseEntity<Object> updateEmployee(@PathVariable int empNo, @RequestBody Employee employee) {
		System.out.println("updateEmployee > " + employee);
		return ResponseEntity.ok(service.modifyEmployee(employee));
	}

	@DeleteMapping("/employees/{empNo}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable int empNo, @RequestBody Employee employee) {
		System.out.println("deleteEmployee > " + employee);
		return ResponseEntity.ok(service.removeEmployee(employee));
	}
}
