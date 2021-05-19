package com.beyondLogic.InstaPortfolio.Repository;

import com.beyondLogic.InstaPortfolio.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}