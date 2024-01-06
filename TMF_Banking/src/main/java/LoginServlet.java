

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		String user=request.getParameter("username");
		String password=request.getParameter("password");
		HttpSession session =request.getSession();
   		session.setAttribute("user", user);
		String DB_URL = "jdbc:mysql://localhost:3306/bank_customers";
        String DB_USER = "root";
        String DB_PASSWORD = "89788";
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        	Statement stmt=conn.createStatement();
        	ResultSet rs=stmt.executeQuery("select *from user_credentials where user='"+user+"' and password='"+password+"'");
        	
       		//HttpSession session= request.getSession();
       	
//       			Object user=session.getAttribute("user");
            
             String res="";
        	if(rs.next()==false) {
        		 res="<html >\r\n"
        				+ "<body>\r\n"
        				+ "<h2>Invalid user or password</h2>\r\n"
        				+ "</body>\r\n"
        				+ "</html>";
        		 out.append(res);
        	}else {
        		
        		response.sendRedirect("http://localhost:8082/TMF_Banking/HomeServlet");
        	}
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        	
        }
		
		
		
	}

}
