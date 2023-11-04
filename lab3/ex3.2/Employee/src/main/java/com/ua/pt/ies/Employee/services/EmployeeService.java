package com.ua.pt.ies.Employee.services;

import com.ua.pt.ies.Employee.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee Employee);

    Employee getEmployeeById(Long EmployeeId);

    List<Employee> getAllEmployees();

    List<Employee> getAllEmployeesByEmail(String email);

    Employee updateEmployee(Employee Employee);

    void deleteEmployee(Long EmployeeId);
}
