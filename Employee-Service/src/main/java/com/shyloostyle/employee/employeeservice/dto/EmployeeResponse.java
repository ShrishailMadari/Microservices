package com.shyloostyle.employee.employeeservice.dto;

import lombok.ToString;


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
