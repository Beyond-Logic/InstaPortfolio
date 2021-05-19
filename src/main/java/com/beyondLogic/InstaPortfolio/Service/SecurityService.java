package com.beyondLogic.InstaPortfolio.Service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}