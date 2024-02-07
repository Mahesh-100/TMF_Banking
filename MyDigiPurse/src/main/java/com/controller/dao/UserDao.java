package com.controller.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.controller.SessionFactoryProvider;
import com.controller.entity.UserDTO;

public class UserDao {
	
	public boolean insertUser(UserDTO user) {
        Transaction transaction = null;
        try (Session session = SessionFactoryProvider.getSessionFactory()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }
	
}
