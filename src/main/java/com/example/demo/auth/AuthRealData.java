package com.example.demo.auth;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("realData")
public class AuthRealData implements AuthDataHandlerInterface {
    @Override
    public AuthResponse addUser(User user) {
        return null;
    }

    @Override
    public AuthResponse removeUser(int id) {
        return null;
    }

    @Override
    public AuthResponse updateUser(User user) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public AuthResponse authenticateUser(User user) {
        return new AuthResponse(false,"there is no real data", user);
    }
}
