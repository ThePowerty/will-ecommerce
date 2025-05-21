package com.williams.will_ecommerce.repositories;

import com.williams.will_ecommerce.auth.entities.util.Role;
import com.williams.will_ecommerce.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
