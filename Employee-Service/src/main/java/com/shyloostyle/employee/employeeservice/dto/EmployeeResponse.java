package com.shyloostyle.employee.employeeservice.dto;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class EmployeeResponse {
    private int id;
    private String name;
    private String email;
    private String bloodGroup;

    public EmployeeResponse() {
    }

    public EmployeeResponse(int id, String name, String email, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bloodGroup = bloodGroup;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
