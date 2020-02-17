package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class RestApIsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApIsApplication.class, args);

    }

//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtUtil jwtTokenUtil;
//
//    @Autowired
//    private MyUserDetailsService userDetailsService;
//
//    @Autowired
//    private AuthServices authServices;
//
//    @RequestMapping(method = RequestMethod.POST,value = "/api/auth")
//    public AuthResponse auth(@RequestBody User user){
//        return authServices.checkAuth(user);
//    }
//
//    @RequestMapping(method = RequestMethod.POST,value = "/api/reg")
//    public RegistrationResponse registration(@RequestBody User user){
//        return authServices.registration(user);
//    }
//
//
//
//    @RequestMapping({ "/hello" })
//    public String firstPage() {
//        return "Hello World";
//    }
//
//    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
//
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
//            );
//        }
//        catch (BadCredentialsException e) {
//            throw new Exception("Incorrect username or password", e);
//        }
//
//
//        final UserDetails userDetails = userDetailsService
//                .loadUserByUsername(authenticationRequest.getUsername());
//
//        final String jwt = jwtTokenUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new AuthenticationResponse(jwt));
//    }

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
