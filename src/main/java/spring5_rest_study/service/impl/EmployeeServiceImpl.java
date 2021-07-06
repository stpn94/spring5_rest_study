package spring5_rest_study.service.impl;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_rest_study.dto.Employee;
import spring5_rest_study.exception.DuplicateEmployeeException;
import spring5_rest_study.mappers.EmployeeMapper;
import spring5_rest_study.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	static final Log log = LogFactory.getLog(GetMemberServiceImpl.class);
	@Autowired
	private EmployeeMapper mapper;

	@Override
	public Employee getEmployee(int empNo) {
		log.debug("service - getEmployee() > " + empNo);
		return mapper.selectEmployeeByNo(empNo);
	}

	@Override
	public List<Employee> getLists() {
		List<Employee> list = mapper.selectEmployeeByAll();
		log.debug("service - getLists() > " + list.size());
		return list;
	}

	@Override
	public int registerEmployee(Employee employee) {
		log.debug("service - registerEmployee() > " + employee);
		if (mapper.selectEmployeeByNo(employee.getEmpNo()) != null) {
			throw new DuplicateEmployeeException("id duplicate");
		}
		return mapper.insertEmployee(employee);
	}

	@Override
	public int modifyEmployee(Employee employee) {
		log.debug("service - modifyEmployee() > " + employee);
		return mapper.updateEmployee(employee);
	}

	@Override
	public int removeEmployee(Employee employee) {
		log.debug("service - removeEmployee() > " + employee);
		return mapper.deleteEmployee(employee);
	}

}
