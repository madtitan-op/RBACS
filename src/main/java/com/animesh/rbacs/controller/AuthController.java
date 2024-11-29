package com.animesh.rbacs.controller;

import com.animesh.rbacs.entity.UserLoginDTO;
import com.animesh.rbacs.service.CustomUserDetailsService;
import com.animesh.rbacs.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDTO user) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.username(), user.password())
        );

        if (auth.isAuthenticated()) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.username());
            String role = userDetails.getAuthorities().iterator().next().getAuthority();
            return jwtService.generateToken(user.username(), role.replace("ROLE_", ""));
        }

        return "Login Failed! Check USERNAME or PASSWORD, and try again!!";
    }

}
