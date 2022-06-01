package com.assignment.demo.Controller;

import com.assignment.demo.DTO.JWTRequest;
import com.assignment.demo.DTO.JWTResponse;
import com.assignment.demo.Service.UserService;
import com.assignment.demo.utility.JWTutility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

@Autowired
private JWTutility jwTutility;

@Autowired
private AuthenticationManager authenticationManager;

@Autowired
private UserService userService;


@GetMapping("/")
public String welcome(){
    return "welcome";
}

@PostMapping("/authenticate")
public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception{

    try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
    }
    catch(BadCredentialsException e){
        throw new Exception("INVALID_CREDENTIALS",e);

    }

    final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
    final String token = jwTutility.generateToken(userDetails);

    return new JWTResponse(token);

}
}
