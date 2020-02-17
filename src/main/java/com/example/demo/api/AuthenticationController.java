package com.example.demo.api;

import com.example.demo.models.User;
import com.example.demo.response.AuthResponse;
import com.example.demo.models.AuthenticationRequest;
import com.example.demo.response.AuthenticationResponse;
import com.example.demo.response.RegistrationResponse;
import com.example.demo.services.AuthServices;
import com.example.demo.services.MyUserDetailsService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private AuthServices authServices;

    @RequestMapping(method = RequestMethod.POST,value = "/api/auth")
    public AuthResponse auth(@RequestBody User user){
        return authServices.checkAuth(user);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/api/reg")
    public RegistrationResponse registration(@RequestBody User user){
        return authServices.registration(user);
    }



    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

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
