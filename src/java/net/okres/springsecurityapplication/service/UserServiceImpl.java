package net.okres.springsecurityapplication.service;

import net.okres.springsecurityapplication.dao.RoleDao;
import net.okres.springsecurityapplication.dao.UserDao;
import net.okres.springsecurityapplication.model.Role;
import net.okres.springsecurityapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex on 15.06.2017.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder; //type of crypt coder

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //get password from user and code to BCrypt
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));//add with role 1(user)
        user.setRoles(roles);//ustanovlenie roley
        userDao.save(user);//sohranenie
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);// get users from BD by username
    }
}
