package com.williams.will_ecommerce.services;

import com.williams.will_ecommerce.auth.entities.util.Role;
import com.williams.will_ecommerce.entities.Employee;
import com.williams.will_ecommerce.repositories.EmployeeRepository;
import com.williams.will_ecommerce.services.interfaces.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    // Inyección del repositorio vía constructor
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}

