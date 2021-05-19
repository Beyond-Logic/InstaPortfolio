package com.beyondLogic.InstaPortfolio.Service;

import com.beyondLogic.InstaPortfolio.Model.User;


public interface UserService {
    void save(User user);

    User findByUsername(String username);
}