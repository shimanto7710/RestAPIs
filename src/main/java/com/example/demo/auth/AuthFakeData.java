package com.example.demo.auth;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository("fakeData")
public class AuthFakeData implements AuthDataHandlerInterface{

    private List<User> userList=new ArrayList<>(Arrays.asList(
            new User("ahmed","123"),
            new User("akkas","456")
    ));

    @Override
    public AuthResponse addUser(User user) {
        for (User item: userList) {
            if (user.getUsername().equals(item.getUsername())){
                return new AuthResponse(false,"already exist",null);
            }
        }

        User newUser = new User(user.getUsername(), user.getPassword());
        userList.add(newUser);
        return new AuthResponse(true,"Registration Successful",newUser);
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
        for (User item: userList) {
            if (user.getPassword().equals(item.getPassword()) && user.getUsername().equals(item.getUsername())){
                return new AuthResponse(true,"Login Successful",user);
            }
        }
        return new AuthResponse(false,"Login Unsuccessful",null);
    }
}
