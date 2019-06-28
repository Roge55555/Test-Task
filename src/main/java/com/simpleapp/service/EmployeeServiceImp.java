package com.simpleapp.service;

import com.simpleapp.dao.EmployeeDao;
import com.simpleapp.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    public EmployeeDao employeeDao;

    @Override
    public void add(Employee employee) {
        employeeDao.add(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeDao.getById(id);
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(Long id) {
        employeeDao.delete(id);
    }
}
