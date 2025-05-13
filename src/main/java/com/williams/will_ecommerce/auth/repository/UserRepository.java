package com.williams.will_ecommerce.auth.repository;

import com.williams.will_ecommerce.auth.entities.User;
import com.williams.will_ecommerce.auth.entities.util.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findByRole(Role role);

    Boolean existsByEmail(String email);
}