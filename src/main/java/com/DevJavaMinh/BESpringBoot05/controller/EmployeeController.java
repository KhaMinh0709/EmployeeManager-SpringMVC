package com.DevJavaMinh.BESpringBoot05.controller;

import com.DevJavaMinh.BESpringBoot05.dto.EmployeeDto;
import com.DevJavaMinh.BESpringBoot05.entity.Employee;
import com.DevJavaMinh.BESpringBoot05.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api_4/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }
    @PostMapping()
    //built create REST API
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto employee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id) {
        EmployeeDto employeeById = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employeeById, HttpStatus.OK);
    }

    @GetMapping()
    public  ResponseEntity<List<EmployeeDto>> getAllEMployee(){
        List<EmployeeDto> list = employeeService.getAllEmployees();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable("id") Long id,
                                              @RequestBody EmployeeDto employeeDto) {
       EmployeeDto employeeDto1 = employeeService.updateEmployee(id, employeeDto);
        return new ResponseEntity<>(employeeDto1, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deletedEmployee(id);
        return ResponseEntity.ok("deleted Employee have id:"+ id);
    }
}
