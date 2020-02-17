package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("realData")
public class AuthRealData implements AuthDataHandlerInterface {

    @Autowired
    UserRepository userRepository;

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
        List<User> users= userRepository.findAll();
        return users;
    }

    @Override
    public AuthResponse authenticateUser(User user) {
        User user1= userRepository.findByNameAndPass(user.getUsername(),user.getPassword());
        if (user1!=null){
            return new AuthResponse(true,"Valid user!",user1);
        }
        return new AuthResponse(false,"There is no such user named "+user.getUsername(), user);
    }
}
