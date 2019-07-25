package com.ToDoApp.ToDo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.ToDoApp.ToDo.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
