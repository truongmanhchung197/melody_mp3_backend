package com.c0720i2.melody.repository;

import com.c0720i2.melody.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
