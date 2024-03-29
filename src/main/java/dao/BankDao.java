
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import db.DBConnection;
import dto.BankAccountDTO;
import dto.TransactionDTO;
import dto.UserDTO;

public class BankDao {
				
	public ArrayList<BankAccountDTO> getAllAccountDetails(String username){
		ArrayList<BankAccountDTO> BankList=new ArrayList<BankAccountDTO>();
		try(Connection connection = DBConnection.getConnection()){
			String query="select *from bank_account where username=?";
			try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
				preparedStatement.setString(1, username);
				ResultSet rs=preparedStatement.executeQuery();
				while(rs.next()) {
					BankAccountDTO bankDao=new BankAccountDTO();
					bankDao.setAccountID(rs.getInt("accountID"));
					bankDao.setAccount_no(rs.getString("bank_account_no"));
					bankDao.setBank_name(rs.getString("bank_name"));
					bankDao.setIFSC_code(rs.getString("IFSC_code"));
					bankDao.setAccount_type(rs.getString("account_type"));
					bankDao.setCurrent_balance(rs.getDouble("current_balance"));
					BankList.add(bankDao);
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return BankList;
	
	}
	
	public UserDTO getUserDetails(String username) {
		
		try (Connection connection = DBConnection.getConnection()) {
            String query = "select *from user_info where username=?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
     //           preparedStatement.setString(2, password);
                
                ResultSet rs=preparedStatement.executeQuery();
                if(rs.next()) {
                	UserDTO resUser= new UserDTO();
                	resUser.setUsername(rs.getString("Username"));
                	resUser.setPassword(rs.getString("password"));
                	resUser.setUser_fullname(rs.getString("User_fullname"));
                	resUser.setPhone_no(rs.getString("phone_no"));
                	resUser.setEmail(rs.getString("email"));
                	resUser.setAddress(rs.getString("user_address"));
                	return resUser;
                }
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean insertUserDTO(UserDTO user) throws SQLException  {
		try (Connection connection = DBConnection.getConnection()){
			String sql = "INSERT INTO user_info (username, password, user_fullname, phone_no, email, user_address) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getUsername() );
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getUser_fullname());
            preparedStatement.setString(4, user.getPhone_no());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.setString(6, user.getAddress());

            int rowsAffected=preparedStatement.executeUpdate();
            return rowsAffected>0;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
	
	public boolean insertBankAccount(BankAccountDTO bank) throws SQLException  {
		try (Connection connection = DBConnection.getConnection()){
			String sql = "INSERT INTO bank_account (username, bank_account_no, bank_name, IFSC_code, account_type, current_balance) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, bank.getUsername() );
            preparedStatement.setString(2, bank.getAccount_no() );
            preparedStatement.setString(3, bank.getBank_name());
            preparedStatement.setString(4, bank.getIFSC_code());
            preparedStatement.setString(5, bank.getAccount_type());
            preparedStatement.setDouble(6, bank.getCurrent_balance());

            int rowsAffected=preparedStatement.executeUpdate();
            return rowsAffected>0;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
	
    public  double getBalance(int accountID) throws SQLException {
        double balance = 0.0;
        try (Connection connection = DBConnection.getConnection()){;
        	String sql="SELECT current_balance FROM bank_account WHERE accountID = ?";
          try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, accountID);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    balance = resultSet.getDouble("current_balance");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return balance;
    }
    }	
	
    public  int getAccountID(String selectedAccountNumber) throws SQLException {
        int accountID = 0;
        try (Connection connection = DBConnection.getConnection()){;
        	String sql="SELECT accountID FROM bank_account WHERE bank_account_no = ?";
          try(PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, selectedAccountNumber);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                	accountID = resultSet.getInt("accountID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountID;
    }
    }
	
	
	
	public boolean updateBalance(int accountID,double newBalance) throws SQLException {
		try (Connection connection = DBConnection.getConnection()){
			String sql="UPDATE bank_account SET current_balance =? WHERE  accountID=?";
			
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				preparedStatement.setDouble(1, newBalance);
				preparedStatement.setInt(2, accountID);
	           
				
	            int rowsAffected = preparedStatement.executeUpdate();
	            return rowsAffected > 0; 
			}catch (SQLException e) {
	            e.printStackTrace(); 
	            return false;
		}
	
	}
	}
	

	public boolean logTransaction(TransactionDTO transaction) {
        String sql = "INSERT INTO transactions (sourceAcctID, targetAcctID, amount, transactionType) " +
                     "VALUES (?, ?, ?, ?)";
        try(Connection connection = DBConnection.getConnection();
        	PreparedStatement preparedStatement = connection.prepareStatement(sql)){
        	preparedStatement.setInt(1, transaction.getSourceAcctID());
            preparedStatement.setInt(2, transaction.getTargetAcctID());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getTransactionType());
        
           
      
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        	
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
}
	

	public ArrayList<TransactionDTO> getAllTransactions(int accountID,Date startDate, Date endDate){
		ArrayList<TransactionDTO> transactions=new ArrayList<TransactionDTO>();
		try(Connection connection = DBConnection.getConnection()){
			String query="SELECT * FROM transactions WHERE (sourceAcctID=? ) and (transactionDate  BETWEEN ? AND ?)";
			try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
				preparedStatement.setInt(1, accountID);
				preparedStatement.setObject(2, new java.sql.Timestamp(startDate.getTime()));
				preparedStatement.setObject(3, new java.sql.Timestamp(endDate.getTime()));

				ResultSet rs=preparedStatement.executeQuery();
				while(rs.next()) {
					TransactionDTO bankDao=new TransactionDTO();
					bankDao.setTransactionID(rs.getInt("transactionID"));
					bankDao.setSourceAcctID(rs.getInt("sourceAcctID"));
					bankDao.setTargetAcctID(rs.getInt("targetAcctID"));
					bankDao.setAmount(rs.getDouble("amount"));
					bankDao.setTransactionType(rs.getString("transactionType"));
					bankDao.setTransactionDate(rs.getDate("transactionDate"));
					transactions.add(bankDao);
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return transactions;
	
	}
	
	
	
	
}	
	
	
		
	

	


