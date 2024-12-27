package com.shyloostyle.employee.employeeservice.service;

import com.shyloostyle.employee.employeeservice.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    Employee getEmployeeById(Integer id);
    Employee createEmployee(Employee employee);
}
