package com.emp.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.ems.entity.Employee;


@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	

}
