package com.springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.mapper.EmployeeMapper;
import com.springboot.app.repository.EmployeeRepository;
import com.springboot.app.vo.EmployeeVO;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeMapper employeeMapper;

	public void saveEmployee(EmployeeVO employeeVO) {

		employeeRepository.save(employeeMapper.getEO(employeeVO));
	}

	public List<EmployeeVO> findByName(String name) {
		return employeeRepository.findByName(name);
	}

	public void deleteEmployee(String name) {
		employeeRepository.deleteByName(name);
	}
}
