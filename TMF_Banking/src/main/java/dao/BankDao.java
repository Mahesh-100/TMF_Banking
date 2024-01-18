package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import dto.BankAccountDTO;
import dto.UserDTO;

public class BankDao {
				
//	public List<BankAccountDTO> getAccountDetails(String username){
//		List<BankAccountDTO> BankList=new ArrayList<BankAccountDTO>();
//		
//		return BankList;
//		
//	}
//	
	public UserDTO getUserDetails(String username,String password) {
		UserDTO resUser= new UserDTO();
		try (Connection connection = DBConnection.getConnection()) {
            String query1 = "select *from user_info where username=? and password=?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query1)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                
                ResultSet rs=preparedStatement.executeQuery();
                while(rs.next()) {
                	resUser.setUsername(rs.getString("Username"));
                	resUser.setUser_fullname(rs.getString("User_fullname"));
                	resUser.setPhone_no(rs.getString("phone_no"));
                	resUser.setEmail(rs.getString("email"));
                	resUser.setAddress(rs.getString("user_address"));
                }
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resUser;
	}
	
	
	
}
