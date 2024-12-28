package com.shyloostyle.employee.employeeservice.controller;

import com.shyloostyle.employee.employeeservice.dto.EmployeeResponse;
import com.shyloostyle.employee.employeeservice.model.Employee;
import com.shyloostyle.employee.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployees(@PathVariable Integer id){
        EmployeeResponse employeeById = employeeService.getEmployeeById(id);
        if (employeeById != null){
            return new ResponseEntity<>(employeeById,HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
    }
    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody Employee employee){
        EmployeeResponse serviceEmployee = employeeService.createEmployee(employee);
        if (serviceEmployee != null){
            return new ResponseEntity<>(serviceEmployee,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
