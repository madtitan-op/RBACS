package com.animesh.rbacs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *ANYONE can access the endpoints within this controller
 */

@RestController
@RequestMapping("/public")
public class PublicAccessController {

    @GetMapping("/")
    public String hello() {
        return "Hello! This endpoint can be accessed by ANYONE";
    }

}
