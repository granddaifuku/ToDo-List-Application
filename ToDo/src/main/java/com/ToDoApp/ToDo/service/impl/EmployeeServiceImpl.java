package com.ToDoApp.ToDo.service.impl;

import java.util.List;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ToDoApp.ToDo.model.Employee;
import com.ToDoApp.ToDo.service.EmployeeService;
import com.ToDoApp.ToDo.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee save(Employee employee) {
		employee.setCreatedDate(new Date());
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			return null;
		}
	}

	@Override
	public Employee update(Employee employee) {
		employee.setUpdatedDate(new Date());
		return employeeRepository.save(employee);
	}

	@Override
	public void delete(Long id) {
		employeeRepository.deleteById(id);		
	}

}
