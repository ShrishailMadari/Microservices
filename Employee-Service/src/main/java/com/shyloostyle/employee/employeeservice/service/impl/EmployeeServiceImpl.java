package com.shyloostyle.employee.employeeservice.service.impl;

import com.shyloostyle.employee.employeeservice.model.Employee;
import com.shyloostyle.employee.employeeservice.repository.EmployeeRepository;
import com.shyloostyle.employee.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        System.out.println(employee);
        return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
