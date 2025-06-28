package com.test.SpringSecurityEx;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Controller {
    
    @GetMapping("/")
    String basicGet(HttpServletRequest req){
        return "Welcome to Secured Page "+ req.getSession().getId();
    }
}
