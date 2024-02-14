package com.controller.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
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
			return true;
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
			return true;
		}catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
		}
		e.printStackTrace();
            }
		return false;	
}

public List<BankDTO> getBankDetailsByUserId(int user_Id) {
	Session session=SessionFactoryProvider.getSessionFactory();
	transaction=session.beginTransaction();
    
    // Write your native SQL query to fetch bank details based on user_id
    String sqlQuery = "select *from bank_info where user_id= :userId";

    // Create a native query
    NativeQuery<BankDTO> query = session.createNativeQuery(sqlQuery, BankDTO.class);
    query.setParameter("userId", user_Id);

    // Execute query and return results
    return query.getResultList();
}
	
}
