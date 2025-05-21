package com.williams.will_ecommerce.auth.entities.util;

import java.util.Arrays;
import java.util.List;

public enum Role {

    OWNER(Arrays.asList(Permission.values())),
    CUSTOMER_ADMIN(Arrays.asList(
            Permission.CREATE_USERS,
            Permission.READ_USERS,
            Permission.UPDATE_USERS,
            Permission.DELETE_USERS
    )),
    EMPLOYEE_ADMIN(Arrays.asList(
            Permission.CREATE_EMPLOYEES,
            Permission.READ_EMPLOYEES,
            Permission.UPDATE_EMPLOYEES,
            Permission.DELETE_EMPLOYEES
    )),
    CARS_ADMIN(Arrays.asList(
            Permission.CREATE_VEHICLES,
            Permission.READ_VEHICLES,
            Permission.UPDATE_VEHICLES,
            Permission.DELETE_VEHICLES
    )),
    SALES_ADMIN(Arrays.asList(
            Permission.CREATE_SALES,
            Permission.READ_SALES,
            Permission.UPDATE_SALES,
            Permission.DELETE_SALES
    )),
    SALES_EMPLOYEE(Arrays.asList(
            Permission.READ_VEHICLES,
            Permission.CREATE_SALES,
            Permission.READ_SALES,
            Permission.READ_USERS
    )),
    CUSTOMER(Arrays.asList(
            Permission.UPDATE_USERS,
            Permission.READ_VEHICLES,
            Permission.MAKE_PURCHASES
    ));

    private List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
