package com.example.demo.auth;

import java.util.List;

public interface AuthDataHandlerInterface {
    public AuthResponse addUser(User user);

    public AuthResponse removeUser(int id);

    public AuthResponse updateUser(User user);

    public List<User> getAllUser();

    public AuthResponse authenticateUser(User user);

}
