package com.ua.pt.ies.Employee.services.servicesImpl;

import lombok.AllArgsConstructor;
import com.ua.pt.ies.Employee.domain.Employee;
import com.ua.pt.ies.Employee.repository.EmployeeRepository;
import com.ua.pt.ies.Employee.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository EmployeeRepository;

    @Override
    public Employee createEmployee(Employee Employee) {
        return EmployeeRepository.save(Employee);
    }

    @Override
    public Employee getEmployeeById(Long EmployeeId) {
        Optional<Employee> optionalEmployee = EmployeeRepository.findById(EmployeeId);
        return optionalEmployee.get();
    }

    @Override
    public List<Employee> getAllEmployeesByEmail(String email){
        List<Employee> Employees = EmployeeRepository.findByEmail(email);
        return Employees;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return EmployeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee Employee) {
        Employee existingEmployee = EmployeeRepository.findById(Employee.getId()).get();
        existingEmployee.setFirstName(Employee.getFirstName());
        existingEmployee.setLastName(Employee.getLastName());
        existingEmployee.setEmail(Employee.getEmail());
        Employee updatedEmployee = EmployeeRepository.save(existingEmployee);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(Long EmployeeId) {
        EmployeeRepository.deleteById(EmployeeId);
    }
}