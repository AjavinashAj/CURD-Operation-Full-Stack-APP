package com.avinashIT.services;

import java.util.List;

import com.avinashIT.dto.EmployeeDto;
import com.avinashIT.entity.Employee;

public interface IEmployeeService {

	Boolean addEmp(EmployeeDto dto);

	Employee getEmpById(Integer id);

	List<Employee> getAllEmp();

	Boolean deleteEmpById(Integer id);

	void editData(Employee emp);

}
