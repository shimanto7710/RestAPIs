package com.example.demo;

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

    public String checkAuth(User user){
        for (User lUser: userList) {
            if (user.getPass().equals(lUser.getPass())){

                return "successful";
            }
        }
        return "Unsuccessful";
    }
}
