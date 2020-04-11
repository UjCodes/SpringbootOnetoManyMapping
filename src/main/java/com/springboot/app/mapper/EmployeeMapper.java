package com.springboot.app.mapper;

import org.springframework.stereotype.Component;

import com.springboot.app.model.Employee;
import com.springboot.app.vo.EmployeeVO;

@Component
public class EmployeeMapper {

	public Employee getEO(EmployeeVO employeeVO) {

		Employee emp = new Employee();
		emp.setAddress(employeeVO.getAddress());
		emp.setDepartment(emp.getDepartment());
		return emp;
	}
}
