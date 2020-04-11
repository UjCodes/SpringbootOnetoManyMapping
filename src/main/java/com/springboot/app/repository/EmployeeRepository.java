package com.springboot.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.app.model.Employee;
import com.springboot.app.vo.EmployeeVO;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	List<EmployeeVO> findByName(String name);

	void deleteByName(String name);

}
