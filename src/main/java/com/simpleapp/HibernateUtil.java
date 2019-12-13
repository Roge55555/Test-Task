package com.simpleapp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionfactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable exeption){
            System.err.print("Hibernate SessionFactory error:" + exeption);
            throw new ExceptionInInitializerError(exeption);
        }
    }

    public static SessionFactory getSessionfactory() {
        return sessionfactory;
    }

    public static void endSession(){
        getSessionfactory().close();
    }
}
