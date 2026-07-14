package com.rohit.SpringJDBCex2;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rohit.SpringJDBCex2.model.Employee;
import com.rohit.SpringJDBCex2.service.EmployeeService;

@SpringBootApplication
public class SpringJdbCex2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbCex2Application.class, args);
		
		Employee emp = context.getBean(Employee.class);
		emp.setId(3);
		emp.setName("John");
		emp.setAge(46);
		emp.setEmail("john@gmail.com");
		
		EmployeeService service = context.getBean(EmployeeService.class);
//		service.addEmployee(emp);
		
		List<Employee> employee = service.getEmployee();
		System.out.println(employee);
		
	}

}
