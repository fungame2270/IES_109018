package com.ua.pt.ies.Employee.controller;

import lombok.AllArgsConstructor;
import com.ua.pt.ies.Employee.domain.Employee;
import com.ua.pt.ies.Employee.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/Employees")
public class EmployeeController {

    private EmployeeService EmployeeService;

    // build create Employee REST API
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee Employee){
        Employee savedEmployee = EmployeeService.createEmployee(Employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    // build get Employee by id REST API
    // http://localhost:8080/api/Employees/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long EmployeeId){
        Employee Employee = EmployeeService.getEmployeeById(EmployeeId);
        return new ResponseEntity<>(Employee, HttpStatus.OK);
    }

    // Build Get All Employees REST API
    // http://localhost:8080/api/Employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(required = false) String email){
        List<Employee> Employees;
        if(email == null){
            Employees = EmployeeService.getAllEmployees();
        }else{
            Employees = EmployeeService.getAllEmployeesByEmail(email);
        }
        return new ResponseEntity<>(Employees, HttpStatus.OK);
    }

    // Build Update Employee REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/Employees/1
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long EmployeeId,
                                           @RequestBody Employee Employee){
        Employee.setId(EmployeeId);
        Employee updatedEmployee = EmployeeService.updateEmployee(Employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    // Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long EmployeeId){
        EmployeeService.deleteEmployee(EmployeeId);
        return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);
    }
}