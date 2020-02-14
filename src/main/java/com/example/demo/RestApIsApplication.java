package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class RestApIsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApIsApplication.class, args);

    }

    @Autowired
    private AuthServices authServices;

    @RequestMapping(method = RequestMethod.POST,value = "/api/auth")
    public String auth(@RequestBody User user){
        return authServices.checkAuth(user);
    }

//    @RequestMapping("/api/{s}")
//    public String l(@PathVariable String s){
//        return s;
//    }

//    @RequestMapping("/api/hello")
//    public String hello(){
//        return "Hello";
//    }

//    @RequestMapping(method = RequestMethod.GET,value = "/topics")
//    public String login(){
//        return "topic.getName()";
//    }

//    @RequestMapping(method = RequestMethod.POST,value = "/post")
//    public String check(@RequestBody Topic topic){
//        return topic.getName();
//    }


}
