package com.simpleapp.config;


import com.simpleapp.dao.EmployeeDao;
import com.simpleapp.dao.EmployeeDaoImpl;
import com.simpleapp.service.EmployeeService;
import com.simpleapp.service.EmployeeServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfiguration {

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/employeedb?useSll=false");
        dataSource.setUsername("springuser");
        dataSource.setPassword("password");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    @Bean
    public EmployeeDao getEmployeeDao(){
        return new EmployeeDaoImpl(getJdbcTemplate());
    }

    @Bean
    public EmployeeService getEmployeeService(){
        return new EmployeeServiceImp();
    }
}
