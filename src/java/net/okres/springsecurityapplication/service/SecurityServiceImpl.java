package net.okres.springsecurityapplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by Alex on 15.06.2017.
 */

@Service
public class SecurityServiceImpl implements SecurityService{

    private  static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);//logirovanie

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();//poluchaem detali nashego usera
        return null;
    }

    @Override
    public void autoLogin(String name, String password) {

    }
}
