package com.ua.pt.ies.Employee.repository;


import com.ua.pt.ies.Employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByEmail(String email);

}
