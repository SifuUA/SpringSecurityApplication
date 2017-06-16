package net.okres.springsecurityapplication.service;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
