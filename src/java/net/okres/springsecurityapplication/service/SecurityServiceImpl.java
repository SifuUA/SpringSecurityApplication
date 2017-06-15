package net.okres.springsecurityapplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
        if (userDetails instanceof UserDetails){
            return ((UserDetails)userDetails).getUsername();//poluchenie imeni zaloginenogo usera
        }
        return null;
    }

    @Override
    public void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        // peredaem prava(name, password, razreshenie)
        authenticationManager.authenticate(authenticationToken);//avtorizaciya

        if (authenticationToken.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            logger.debug(String.format("Successfully %s auto logged in.", username));
        }
    }
}
