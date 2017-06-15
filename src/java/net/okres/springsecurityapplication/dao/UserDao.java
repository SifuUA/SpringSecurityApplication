package net.okres.springsecurityapplication.dao;

import net.okres.springsecurityapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alex on 15.06.2017.
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
