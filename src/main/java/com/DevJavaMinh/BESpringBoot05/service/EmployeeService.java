package com.DevJavaMinh.BESpringBoot05.service;

import com.DevJavaMinh.BESpringBoot05.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
     List<EmployeeDto>  getAllEmployees();
    EmployeeDto updateEmployee(Long id,EmployeeDto employeeDto);
    void deletedEmployee(Long id);
}
