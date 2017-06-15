package net.okres.springsecurityapplication.service;

/**
 * Created by Alex on 15.06.2017.
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String name, String password);

}
