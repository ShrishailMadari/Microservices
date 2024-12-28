package com.shyloostyle.employee.employeeservice.service.impl;

import com.shyloostyle.employee.employeeservice.dto.EmployeeResponse;
import com.shyloostyle.employee.employeeservice.model.Employee;
import com.shyloostyle.employee.employeeservice.repository.EmployeeRepository;
import com.shyloostyle.employee.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse getEmployeeById(Integer id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        return convertToDto(employee);
    }

    private EmployeeResponse convertToDto(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getId());
        employeeResponse.setName(employee.getName());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setBloodGroup(employee.getBloodGroup());
        return employeeResponse;
    }

    @Override
    public EmployeeResponse createEmployee(Employee employee) {
        Employee saved = employeeRepository.save(employee);
        return convertToDto(saved);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
//        equals() can create the list of response or u can use streams
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream()
                .map(employee -> new EmployeeResponse(employee.getId(), employee.getName(), employee.getEmail(), employee.getBloodGroup()))
                .toList();

    }

    @Override
    public EmployeeResponse updateEmployeeById(Integer id, Employee employee) {
        //first find the Existing employee and then update
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow();
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setBloodGroup(employee.getBloodGroup());
        //save the existing employee by updating it
        Employee saved = employeeRepository.save(existingEmployee);
        return convertToDto(saved);
    }
}
