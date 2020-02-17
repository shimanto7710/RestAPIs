package com.example.demo.services;

import com.example.demo.response.AuthResponse;
import com.example.demo.response.RegistrationResponse;
import com.example.demo.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthServices {

    private List<User> userList=new ArrayList<>(Arrays.asList(
            new User("1","ahmed","123"),
            new User("2","akkas","456")
    ));

    public AuthResponse checkAuth(User user){
        for (User item: userList) {
            if (user.getPass().equals(item.getPass()) && user.getUserId().equals(item.getUserId())){
                return new AuthResponse(true,"Login Successful","1111");
            }
        }
        return new AuthResponse(false,"Login Unsuccessful",null);
    }

    public RegistrationResponse registration(User user) {
        for (User item: userList) {
            if (user.getUserId().equals(item.getUserId())){
                return new RegistrationResponse(false,"already exist",null);
            }
        }

        User newUser = new User(String.valueOf(userList.size()+1), user.getUserId(), user.getPass());
        userList.add(newUser);
        return new RegistrationResponse(true,"Registration Successful",newUser);
    }
}
