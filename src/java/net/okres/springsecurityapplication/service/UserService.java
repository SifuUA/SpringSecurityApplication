package net.okres.springsecurityapplication.service;

import net.okres.springsecurityapplication.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
