package com.example.demo.auth;

public class AuthResponse {
    private boolean isSuccess;
    private String message;
    private User user;

    public AuthResponse(boolean isSuccess, String message, User user) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.user = user;
    }

    @Override
    public String toString() {
        return "RegistrationResponse{" +
                "isSuccess=" + isSuccess +
                ", message='" + message + '\'' +
                ", user=" + user +
                '}';
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
