package com.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.service.EmployeeService;
import com.springboot.app.vo.EmployeeVO;

/**
 * @author Upendra
 *
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * @param empname
	 * @return
	 * @throws AppException
	 */
	@GetMapping("/getEmp")
	public ResponseEntity<List<EmployeeVO>> getEmpByName(@RequestParam String name) {

		List<EmployeeVO> employeeList = employeeService.findByName(name);
		return new ResponseEntity<>(employeeList, HttpStatus.OK);

	}

	/**
	 * @return
	 */

	@GetMapping(value = "/getAllEmp", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeVO>> getAllEmp() {
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	/**
	 * @param employee
	 * @return
	 */
	@PutMapping("/update")
	public ResponseEntity<EmployeeVO> updateEmployee(@RequestBody EmployeeVO employee) {
		employeeService.saveEmployee(employee);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	/**
	 * @param employee
	 * @return
	 */
	@PostMapping(value = "/add", produces = "text/plain")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeVO employee) {

		employeeService.saveEmployee(employee);

		return new ResponseEntity<>("Success", HttpStatus.OK);

	}

	/**
	 * @param empid
	 * @return
	 */
	@DeleteMapping(value = "/delete", produces = "text/plain")
	public ResponseEntity<String> deleteEmployee(@RequestParam String name) {

		employeeService.deleteEmployee(name);

		return new ResponseEntity<>("Success", HttpStatus.OK);
	}

}
