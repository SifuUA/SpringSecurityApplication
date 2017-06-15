package net.okres.springsecurityapplication.service;

import net.okres.springsecurityapplication.model.User;

/**
 * Created by Alex on 15.06.2017.
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
