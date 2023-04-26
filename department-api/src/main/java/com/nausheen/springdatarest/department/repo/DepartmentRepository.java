package com.nausheen.springdatarest.department.repo;

import org.springframework.data.repository.CrudRepository;

import com.nausheen.springdatarest.department.entities.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
