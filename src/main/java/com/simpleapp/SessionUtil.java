package com.simpleapp;

import org.hibernate.Transaction;
import org.hibernate.Session;


public class SessionUtil {
    private Session session;
    private Transaction transaction;

    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Session openSession(){
        return HibernateUtil.getSessionfactory().openSession();
    }

    public Session openTransaction(){
        session = openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeTransaction(){
        transaction.commit();
        closeSession();
    }

    public void closeSession(){
        session.close();
    }
}
