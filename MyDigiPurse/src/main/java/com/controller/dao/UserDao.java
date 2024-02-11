package com.controller.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.controller.SessionFactoryProvider;
import com.controller.entity.BankDTO;
import com.controller.entity.UserDTO;



public class UserDao {
	Transaction transaction = null;
	public boolean saveUserDetails(UserDTO user) {
		
		
		try {
			Session session = SessionFactoryProvider.getSessionFactory();
			 transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			session.close();
			return false;
		}catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
		}
		
            e.printStackTrace();
            
		
	}
		return false;
	
}

	public UserDTO showUserDetails(String username, String password) {
		Session session=SessionFactoryProvider.getSessionFactory();
		transaction=session.beginTransaction();
		Query<UserDTO> query = session.createQuery("FROM UserDTO WHERE username = :username AND password = :password", UserDTO.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        return query.uniqueResult();
		
	}
	
	
public boolean saveBankDetails(BankDTO bank) {
		
		
		try {
			Session session = SessionFactoryProvider.getSessionFactory();
			 transaction = session.beginTransaction();
			session.save(bank);
			transaction.commit();
			session.close();
			return false;
		}catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
		}
		
            e.printStackTrace();
            
		
	}
		return false;
	
}
	
}
