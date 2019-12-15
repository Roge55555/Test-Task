package com.simpleapp.dao;

import com.simpleapp.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

}
