package com.simpleapp.dao;

import com.simpleapp.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Employee employee) {
        String sql = "INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(), employee.getJobTitle(), employee.getGender(), employee.getDateOfBirth());
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new EmployeeMapper());
    }

    @Override
    public Employee getById(Long id) {
        String sql = "SELECT * FROM employee WHERE employee_id = ?";
        return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employee SET first_name = ?, last_name = ?, department_id = ?, job_title = ?, gender = ?, date_of_birth = ? WHERE employee_id = ?";
        jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getDepartmentId(), employee.getJobTitle(), employee.getGender(), employee.getDateOfBirth(), employee.getEmployeeId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM employee WHERE employee_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
