package com.shyloostyle.employee.employeeservice.service;

import com.shyloostyle.employee.employeeservice.dto.EmployeeResponse;
import com.shyloostyle.employee.employeeservice.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface EmployeeService {
    EmployeeResponse getEmployeeById(Integer id);
    EmployeeResponse createEmployee(Employee employee);
    List<EmployeeResponse> getAllEmployees();
    EmployeeResponse updateEmployeeById(Integer id, Employee employee);
}
