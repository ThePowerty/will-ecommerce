package com.williams.will_ecommerce.entities;

import com.williams.will_ecommerce.auth.entities.User;
import com.williams.will_ecommerce.auth.entities.util.Role;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee extends User {

    private LocalDate hiring_date;
    private LocalDate termination_date;

    public Employee() {
    }

    public Employee(String username, String email, String password, Role role) {
        super(username, email, password);
        super.setRole(role);
        this.hiring_date = LocalDate.now();
        this.termination_date = null;
    }

    public LocalDate getHiring_date() {
        return hiring_date;
    }

    public void setHiring_date(LocalDate hiring_date) {
        this.hiring_date = hiring_date;
    }

    public LocalDate getTermination_date() {
        return termination_date;
    }

    public void setTermination_date(LocalDate termination_date) {
        this.termination_date = termination_date;
    }
}
