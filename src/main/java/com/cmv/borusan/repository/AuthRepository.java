package com.cmv.borusan.repository;

import com.cmv.borusan.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User,Long> {
}
