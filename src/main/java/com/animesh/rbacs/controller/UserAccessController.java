package com.animesh.rbacs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *Users with USER as well as ADMIN role can access the endpoints within this controller
 */

@RestController
@RequestMapping("/user")
public class UserAccessController {

    @GetMapping("/")
    public String userAccess() {
        return "This is USER endpoint";
    }

}
