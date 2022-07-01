package com.cmv.borusan.repository;


import java.util.Optional;

import com.cmv.borusan.model.entity.Role;
import com.cmv.borusan.model.type.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(UserRole name);
}