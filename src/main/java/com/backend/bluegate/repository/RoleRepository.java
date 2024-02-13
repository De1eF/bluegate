package com.backend.bluegate.repository;

import com.backend.bluegate.model.UserRole;
import com.backend.bluegate.model.UserRole.RoleName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByRoleName(RoleName roleName);
}
