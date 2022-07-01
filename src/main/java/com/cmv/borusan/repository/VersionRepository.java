package com.cmv.borusan.repository;

import com.cmv.borusan.model.entity.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<Version,Long> {
}
