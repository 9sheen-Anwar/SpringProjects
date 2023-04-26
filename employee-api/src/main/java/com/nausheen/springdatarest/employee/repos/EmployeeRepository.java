package com.nausheen.springdatarest.employee.repos;

import org.springframework.data.repository.CrudRepository;

import com.nausheen.springdatarest.employee.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
