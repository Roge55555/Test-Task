package com.simpleapp.dao;

import com.simpleapp.SessionUtil;
import com.simpleapp.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao extends SessionUtil {

    public void add(Employee employee) {

          openTransaction();

          Session session = getSession();
          session.save(employee);

          closeTransaction();
    }

    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";

        openTransaction();

        Session session = getSession();

        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        List<Employee> list = query.list();

        closeTransaction();

        return list;
    }

    public Employee getById(Long id) {
        String sql = "SELECT * FROM employee WHERE employeeId = :id";

        openTransaction();

        Session session = getSession();

        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id", id);

        Employee employee = (Employee) query.getSingleResult();

        closeTransaction();

        return employee;
    }

    public void update(Employee employee) {

        openTransaction();

        Session session = getSession();
        session.update(employee);

        closeTransaction();
    }

    public void delete(Long id) {

        openTransaction();

        Session session = getSession();
        session.delete(id);

        closeTransaction();
    }
}
