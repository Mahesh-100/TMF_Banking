

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userFullname = request.getParameter("user_fullname");
        String phoneNo = request.getParameter("phone_no");
        String email = request.getParameter("email");
        String userAddress = request.getParameter("user_address");

        try (Connection connection = DBConnection.getConnection()) {
            String sql = "INSERT INTO user_info (username, password, user_fullname, phone_no, email, user_address) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, userFullname);
                preparedStatement.setString(4, phoneNo);
                preparedStatement.setString(5, email);
                preparedStatement.setString(6, userAddress);

                preparedStatement.executeUpdate();
            }
            	//request.setAttribute("message", "Registered succesfully...! Login here");
            	RequestDispatcher rd= request.getRequestDispatcher("login.html");
            	rd.forward(request, response);
            
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
	}

}
