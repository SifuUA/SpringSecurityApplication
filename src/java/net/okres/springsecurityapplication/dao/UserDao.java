package net.okres.springsecurityapplication.dao;

import net.okres.springsecurityapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
