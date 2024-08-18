package com.DevJavaMinh.BESpringBoot05.service.EmployeeServiceImpl;

import com.DevJavaMinh.BESpringBoot05.dto.EmployeeDto;
import com.DevJavaMinh.BESpringBoot05.entity.Employee;
import com.DevJavaMinh.BESpringBoot05.exception.ResourceExceptionNOtFound;
import com.DevJavaMinh.BESpringBoot05.mapper.EmployeeMapper;
import com.DevJavaMinh.BESpringBoot05.repository.EmpolyeeRepository;
import com.DevJavaMinh.BESpringBoot05.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private  final EmpolyeeRepository empolyeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.maptoEmployee(employeeDto);
        Employee savedEmployee = empolyeeRepository.save(employee);

        return EmployeeMapper.maptoEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = empolyeeRepository.findById(id)
                .orElseThrow(()-> new ResourceExceptionNOtFound("not found"));
        return EmployeeMapper.maptoEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> list = empolyeeRepository.findAll();
        return list.stream().map(EmployeeMapper::maptoEmployeeDto).toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long id,EmployeeDto employeeDto) {
        Employee employee = empolyeeRepository.findById(id)
                .orElseThrow(()->new ResourceExceptionNOtFound("not found"));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        Employee employeeUpdated = empolyeeRepository.save(employee);


        return EmployeeMapper.maptoEmployeeDto(employeeUpdated);
    }

    @Override
    public void deletedEmployee(Long id) {
        Employee Employee = empolyeeRepository.findById(id)
                .orElseThrow(()->new ResourceExceptionNOtFound("no found"));
        empolyeeRepository.deleteById(id);

    }

}
