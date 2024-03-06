package com.emp.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.emp.ems.dto.EmployeeDto;
import com.emp.ems.entity.Employee;
import com.emp.ems.exception.ResourceNotFoundException;
import com.emp.ems.mapper.EmployeeMapper;
import com.emp.ems.repository.EmployeeRepository;
import com.emp.ems.service.EmployeeService;
import com.emp.ems.exception.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// Map DTO to entity
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

		// Save the entity
		Employee savedEmployee = employeeRepository.save(employee);

		// Map the saved entity back to DTO
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee does not exist with the given ID: " + employeeId));

		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());

	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee does not exist with the given ID: " + employeeId));

		employee.setFirstname(updatedEmployee.getFirstName());
		employee.setLastname(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());

		Employee updatedEmployeeObj = employeeRepository.save(employee);

		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {

		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee does not exist with the given ID: " + employeeId));
		
		employeeRepository.deleteById(employeeId);

		// TODO Auto-generated method stub

	}

}
