package com.williams.will_ecommerce.services.interfaces;

import com.williams.will_ecommerce.auth.entities.util.Role;
import com.williams.will_ecommerce.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
    Employee save(Employee employee);
    void deleteById(Long id);
}
