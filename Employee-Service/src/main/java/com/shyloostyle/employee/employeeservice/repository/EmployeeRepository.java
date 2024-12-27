package com.shyloostyle.employee.employeeservice.repository;

import com.shyloostyle.employee.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
