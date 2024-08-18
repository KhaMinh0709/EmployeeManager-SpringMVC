package com.DevJavaMinh.BESpringBoot05.mapper;

import com.DevJavaMinh.BESpringBoot05.dto.EmployeeDto;
import com.DevJavaMinh.BESpringBoot05.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto maptoEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
    public static Employee maptoEmployee(EmployeeDto employeeDto) {
      return   new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
