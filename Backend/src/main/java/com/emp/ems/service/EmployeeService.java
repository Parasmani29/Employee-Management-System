package com.emp.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emp.ems.dto.EmployeeDto;

@Service
public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    
    
    EmployeeDto getEmployeeById(Long employeeId);
    
    List<EmployeeDto> getAllEmployees();
    
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);
    
    void deleteEmployee(Long employeeId);
}
