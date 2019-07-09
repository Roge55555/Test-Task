package com.simpleapp.service;

import com.simpleapp.dto.Employee;

import java.util.List;

public interface EmployeeService {

    //create
    void add(Employee employee);

    //read
    List<Employee> findAll();

    Employee getById(Long id);

    //update
    Employee update(Employee employee);

    //delete
    void delete(Long id);
}
