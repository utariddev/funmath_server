package org.utarid.funmath.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.utarid.funmath.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
