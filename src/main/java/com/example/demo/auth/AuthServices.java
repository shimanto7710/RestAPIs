package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthServices {

    private AuthDataHandlerInterface authDataHandlerInterface;

    @Autowired
    public AuthServices(@Qualifier("fakeData") AuthDataHandlerInterface authDataHandlerInterface){
        this.authDataHandlerInterface=authDataHandlerInterface;
    }

    public AuthResponse addUser(User user){
        return authDataHandlerInterface.addUser(user);
    }

    public AuthResponse removeUser(int id){
        return authDataHandlerInterface.removeUser(id);
    }

    public AuthResponse updateUser(User user){
        return authDataHandlerInterface.updateUser(user);
    }

    public List<User> getAllUser(){
        return authDataHandlerInterface.getAllUser();
    }

    public AuthResponse authenticateUser(User user) {
        return authDataHandlerInterface.authenticateUser(user);
    }

//    private List<User> userList=new ArrayList<>(Arrays.asList(
//            new User("1","ahmed","123"),
//            new User("2","akkas","456")
//    ));
//
//    public AuthResponse checkAuth(User user){
//        for (User item: userList) {
//            if (user.getPass().equals(item.getPass()) && user.getUserId().equals(item.getUserId())){
//                return new AuthResponse(true,"Login Successful",user);
//            }
//        }
//        return new AuthResponse(false,"Login Unsuccessful",null);
//    }
//
//    public AuthResponse registration(User user) {
//        for (User item: userList) {
//            if (user.getUserId().equals(item.getUserId())){
//                return new AuthResponse(false,"already exist",null);
//            }
//        }
//
//        User newUser = new User(String.valueOf(userList.size()+1), user.getUserId(), user.getPass());
//        userList.add(newUser);
//        return new AuthResponse(true,"Registration Successful",newUser);
//    }
}
