package spring5_rest_study.mappers;

import java.util.List;

import org.springframework.stereotype.Component;

import spring5_rest_study.dto.Employee;

@Component
public interface EmployeeMapper {
	Employee selectEmployeeByNo(int empNo);

	List<Employee> selectEmployeeByAll();

	int insertEmployee(Employee employee);

	int updateEmployee(Employee employee);

	int deleteEmployee(Employee employee);

}
