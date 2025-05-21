package com.williams.will_ecommerce.auth.controller;

import com.williams.will_ecommerce.auth.entities.User;
import com.williams.will_ecommerce.auth.entities.util.Role;
import com.williams.will_ecommerce.auth.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    protected UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        log.info("REST request to find one user");
        Optional<User> userOpt = this.userService.findById(id);

        return userOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        log.info("REST request to find all user");
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id){
        log.info("REST request to delete an user by id");

        this.userService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        log.info("REST request to count all users");
        Long count = this.userService.count();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<User>> findByRole(@PathVariable Role role) {
        log.info("REST request to find user by Role: " + role.name());
        List<User> users = this.userService.findByRole(role);
        return ResponseEntity.ok(users);
    }
}
