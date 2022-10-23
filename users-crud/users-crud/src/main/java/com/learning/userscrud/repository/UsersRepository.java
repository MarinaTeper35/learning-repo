package com.learning.userscrud.repository;

import com.learning.userscrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}
