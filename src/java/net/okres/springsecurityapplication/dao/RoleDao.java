package net.okres.springsecurityapplication.dao;

import net.okres.springsecurityapplication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alex on 15.06.2017.
 */
public interface RoleDao extends JpaRepository<Role, Long>{
}
