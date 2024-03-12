package com.avinashIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avinashIT.dto.EmployeeDto;
import com.avinashIT.entity.Employee;
import com.avinashIT.response.ResponseObject;
import com.avinashIT.services.IEmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	@PostMapping("/save")
	public ResponseEntity<ResponseObject> saveData(@RequestBody EmployeeDto dto) {
		Boolean status = employeeService.addEmp(dto);
		String message = status ? "Employee added Successfully..." : "Fail to Add Employee....";
		ResponseObject responseObject = new ResponseObject(message);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseObject);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id) {
		Employee emp = employeeService.getEmpById(id);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getAllData() {
		return new ResponseEntity<List<Employee>>(employeeService.getAllEmp(), HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmp(@RequestParam("id") Integer id) {
		String temp = "";
		Boolean status = employeeService.deleteEmpById(id);
		if (status) {
			temp = id + "-:deleted successfully..";
		} else {
			temp = "Fail to delete ...";
		}
		return new ResponseEntity<String>(temp, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp) {

		employeeService.editData(emp);
		return ResponseEntity.ok().build();

	}

}
