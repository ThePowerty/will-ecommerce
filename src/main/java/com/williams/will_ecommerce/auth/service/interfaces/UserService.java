package com.williams.will_ecommerce.auth.service.interfaces;

import com.williams.will_ecommerce.auth.entities.User;
import com.williams.will_ecommerce.auth.entities.util.Role;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    Long count();

    User save(User user);

    void deleteById(Long id);

    List<User> findByRole(Role role);
}
