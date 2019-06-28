package com.simpleapp.dao;

import com.simpleapp.dto.Employee;

import java.util.List;

public interface EmployeeDao {

    //create
    void add(Employee employee);

    //read
    List<Employee> findAll();

    Employee getById(Long id);

    //update
    void update(Employee employee);

    //delete
    void delete(Long id);



}
