package net.okres.springsecurityapplication.dao;

import net.okres.springsecurityapplication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
