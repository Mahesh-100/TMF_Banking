package com.controller.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.controller.SessionFactoryProvider;
import com.controller.entity.UserDTO;

public class UserDao {
	
	public  boolean saveData(UserDTO user) {
		Session session=SessionFactoryProvider.getSessionFactory();
		Transaction txn=session.beginTransaction();
		session.save(user);
		txn.commit();
		session.close();
		return false;
	}
	
}
