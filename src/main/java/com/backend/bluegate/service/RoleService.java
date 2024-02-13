package com.backend.bluegate.service;

import com.backend.bluegate.model.UserRole;

public interface RoleService {
    UserRole add(UserRole role);

    UserRole findByRoleName(String roleName);
}
