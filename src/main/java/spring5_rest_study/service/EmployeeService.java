package spring5_rest_study.service;

import java.util.List;

import org.springframework.stereotype.Service;

import spring5_rest_study.dto.Employee;
@Service
public interface EmployeeService {
	Employee getEmployee(int empNo);

	List<Employee> getLists();

	int registerEmployee(Employee employee);

	int modifyEmployee(Employee employee);

	int removeEmployee(Employee employee);
}