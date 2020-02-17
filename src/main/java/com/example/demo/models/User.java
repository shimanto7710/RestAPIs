package com.example.demo.models;

public class User {
    private String id;
    private String userId;
    private String pass;
    private String token;

    public User(String id, String userId, String pass) {
        this.id = id;
        this.userId = userId;
        this.pass = pass;
    }

//    public User(String userId, String pass) {
//        this.userId = userId;
//        this.pass = pass;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + userId + '\'' +
                ", pass='" + pass + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
