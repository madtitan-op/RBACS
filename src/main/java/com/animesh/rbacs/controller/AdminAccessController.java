package com.animesh.rbacs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*Only users with ADMIN role can access the endpoints within this controller
 */

@RestController
@RequestMapping("/admin")
public class AdminAccessController {

    @GetMapping("/")
    public String adminAccess() {
        return "This is ADMIN endpoint";
    }

}
