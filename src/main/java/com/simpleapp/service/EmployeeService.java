package com.simpleapp.service;

import com.simpleapp.dao.EmployeeDao;
import com.simpleapp.entity.Employee;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private EmployeeDao employeeDao;

//    public EmployeeService(EmployeeDao employeeDao) {
//        this.employeeDao = employeeDao;
//    }

    public void add(Employee employee) {
        employeeDao.save(employee);
    }

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public Employee getById(Long id) {
        return employeeDao.getOne(id);
    }

    public Employee update(Employee employee) {
        employeeDao.save(employee);
        return employee;
    }

    public void delete(Long id) {
        employeeDao.deleteById(id);
    }
}
