package com.demo.SpringSecurityEx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringSecurityEx.dao.EmpDao;
import com.demo.SpringSecurityEx.pojo.Employee;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Controller {

    @Autowired
    EmpDao dao;

    @GetMapping("/token")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/getAll")
    public List<Employee> getEmployees() {
        return dao.findAll();
    }

    @PostMapping("/createEmp")
    public Employee save(Employee e) {
        return dao.save(e);
    }
}
