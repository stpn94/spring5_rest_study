package spring5_rest_study.mappers;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import spring5_rest_study.config.ContextRoot;
import spring5_rest_study.dto.Dept;
import spring5_rest_study.dto.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@WebAppConfiguration
public class EmployeeMapperTest {
	protected static final Log log = LogFactory.getLog(EmployeeMapperTest.class);

	@Autowired
	private EmployeeMapper mapper;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test2SelectEmployeeByNo() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Employee Employee = mapper.selectEmployeeByNo(5000);
		Assert.assertNotNull(Employee);

		log.debug(Employee.toString());
	}

	@Test
	public void test3SelectEmployeeByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Employee> list = mapper.selectEmployeeByAll();
		Assert.assertNotNull(list);

		list.forEach(s -> log.debug(s.toString()));
	}

	@Test
	public void test1InsertEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee newEmployee = new Employee(5000, "이종윤", "대리", new Employee(4377), 2000000, new Dept(2));

		int res = mapper.insertEmployee(newEmployee);
		Assert.assertEquals(1, res);

	}

	@Test
	public void test4UpdateEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee upEmployee = new Employee(5000, "이종윤-수정", "과장", new Employee(1003), 3000000, new Dept(1));
		int res = mapper.updateEmployee(upEmployee);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test5DeleteEmployee() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Employee delEmployee = new Employee(5000);
		int res = mapper.deleteEmployee(delEmployee);
		Assert.assertEquals(1, res);
	}

}
