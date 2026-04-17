package com.demo.SpringSecurityEx.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.SpringSecurityEx.pojo.Employee;

@Repository
public class EmpDao {
    List<Employee> empList = new ArrayList<>();

    public Employee save(Employee e) {
        empList.add(e);
        return e;
    }

    public List<Employee> findAll() {
        return empList;
    }
}
