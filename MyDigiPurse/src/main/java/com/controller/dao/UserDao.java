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


public double getCurrentBalance(int accountId) {
	Session session=SessionFactoryProvider.getSessionFactory();
	transaction=session.beginTransaction();
    
    // Write your Hibernate query to retrieve the current balance
    String hql = "SELECT b.current_balance FROM BankDTO b WHERE b.id = :accountId";
    
    // Create a Hibernate query object
    Query<Double> query = session.createQuery(hql, Double.class);
    query.setParameter("accountId", accountId);
    
    // Execute the query and return the result
    return query.uniqueResult();
}


public boolean updateBalance(int accountId, double newBalance) {
	Session session=SessionFactoryProvider.getSessionFactory();
	transaction=session.beginTransaction();

    try {
        // Write your Hibernate query to update the balance
        String hql = "UPDATE BankDTO b SET b.current_balance = :newBalance WHERE b.id = :accountId";

        // Create a Hibernate query object
        int updatedRows = session.createQuery(hql)
                                .setParameter("newBalance", newBalance)
                                .setParameter("accountId", accountId)
                                .executeUpdate();

        // Return true if at least one row was updated
        return updatedRows > 0;
    } catch (Exception e) {
    	e.printStackTrace();
        return false;
    }
	
}
}