package com.shyloostyle.employee.employeeservice.service;

import com.shyloostyle.employee.employeeservice.dto.EmployeeResponse;
import com.shyloostyle.employee.employeeservice.model.Employee;
import org.springframework.stereotype.Service;


@Service
public interface EmployeeService {
    EmployeeResponse getEmployeeById(Integer id);
    EmployeeResponse createEmployee(Employee employee);
}
