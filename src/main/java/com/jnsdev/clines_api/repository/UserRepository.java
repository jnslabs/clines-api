package com.jnsdev.clines_api.repository;

import com.jnsdev.clines_api.repository.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Autor Jairo Nascimento
 * @Created 29/09/2024 - 12:09
 */
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
}
