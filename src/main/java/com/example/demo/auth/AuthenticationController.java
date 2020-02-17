package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private AuthServices authServices;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST,value = "/auth")
    public AuthResponse auth(@RequestBody User user){
        return authServices.authenticateUser(user);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/reg")
    public AuthResponse registration(@RequestBody User user){
        return authServices.addUser(user);
    }

//    @PostMapping(value = "/login")
//    public User userValidity(@RequestBody User user){
//        return userRepository.findByName(user.getUsername());
//    }

    @GetMapping(value = "/getalluser")
    public List<User> getAll(){
        return authServices.getAllUser();
    }


    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
