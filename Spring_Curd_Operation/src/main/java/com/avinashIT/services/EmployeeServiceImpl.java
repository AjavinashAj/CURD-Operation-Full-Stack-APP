package com.avinashIT.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avinashIT.dto.EmployeeDto;
import com.avinashIT.entity.Employee;
import com.avinashIT.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Boolean addEmp(EmployeeDto dto) {
		Employee employee = new Employee();
		if (dto != null) {
			BeanUtils.copyProperties(dto, employee);
			employeeRepository.save(employee);
			return true;
		}
		return false;
	}

	@Override
	public Employee getEmpById(Integer id) {
		if (id != null) {
			Employee employee = employeeRepository.findById(id).get();
			return employee;
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmp() {

		return employeeRepository.findAll();
	}

	@Override
	public Boolean deleteEmpById(Integer id) {
		if (id != null && employeeRepository.findById(id).isPresent()) {
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public void editData(Employee emp) {

		if (employeeRepository.findById(emp.getEmpId()).isPresent()) {
			employeeRepository.save(emp);
		}

	}

}
