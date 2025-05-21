package com.williams.will_ecommerce.controllers;

import com.williams.will_ecommerce.auth.entities.User;
import com.williams.will_ecommerce.auth.entities.util.Role;
import com.williams.will_ecommerce.entities.Employee;
import com.williams.will_ecommerce.services.interfaces.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        log.info("REST request to create a new employee");
        employee.setRole(Role.SALES_EMPLOYEE); // Asigna un rol por defecto
        Employee savedEmployee = employeeService.save(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        log.info("REST request to update employee with id: " + id);
        Optional<Employee> existingEmployeeOpt = employeeService.findById(id);

        if (existingEmployeeOpt.isPresent()) {
            employee.setId(id);
            Employee updatedEmployee = employeeService.save(employee);
            return ResponseEntity.ok(updatedEmployee);
        }

        log.warn("Update employee failed for id: " + id);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/permission/{id}/{role}")
    public ResponseEntity<Employee> updateRole(@PathVariable Long id, @PathVariable Role role) {
        if (this.employeeService.findById(id).isPresent()) {
            Employee employee = this.employeeService.findById(id).get();

            if (!employee.getRole().equals(role)) {
                employee.setRole(role);
                log.info("REST request to update Role: " + role + "  a employee with id: " + employee.getId());

                return ResponseEntity.ok(this.employeeService.save(employee));
            }
        }
        log.warn("Update Role failed");
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        log.info("REST request to find employee by id: " + id);
        Optional<Employee> employeeOpt = employeeService.findById(id);

        return employeeOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAll() {
        log.info("REST request to find all employees");
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        log.info("REST request to delete employee with id: " + id);
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
