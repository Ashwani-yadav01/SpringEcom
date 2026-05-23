package com.Ashwani.Portfolio.repositories;

import com.Ashwani.Portfolio.model.AppRole;
import com.Ashwani.Portfolio.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole role);
}
