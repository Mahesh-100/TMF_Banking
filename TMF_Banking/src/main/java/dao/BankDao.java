package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import db.DBConnection;
import dto.BankAccountDTO;
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
	

	
}
	
	
	
	
	
		
	
	
	

