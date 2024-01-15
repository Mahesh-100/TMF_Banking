

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
          }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try (Connection connection = DBConnection.getConnection()) {
            String query1 = "select us.*,ba.*from user_info us join bank_account ba on us.username=ba.username where us.username= ? and password=?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query1)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                
                ResultSet rs=preparedStatement.executeQuery();
                String res="";
            	if(rs.next()==false) {
           		    res="<html >\r\n"
           				+ "<body>\r\n"
           				+ "<h2>Unknown user</h2>\r\n"
           				+ "</body>\r\n"
           				+ "</html>";
           		 out.append(res); 
            	}else {
            		
            		res="\r\n"
            				+ "<html>\r\n"
            				+ "<head>\r\n"
            				+"<meta charset=\"UTF-8\">"
            				+ "\r\n"
            				+ "<title>Home</title>\r\n"
            				+ "<style>\r\n"
            				+ "body {\r\n"
            				+ "            font-family: Arial, sans-serif;\r\n"
            				+ "            margin: 0;\r\n"
            				+ "            display: flex;\r\n"
            				+ "            flex-direction: column;\r\n"
            				+ "            align-items: center;\r\n"
            				+ "            justify-content: center;\r\n"
            				+ "            height: 100vh;\r\n"
            				+ "        }\r\n"
            				+ "\r\n"
            				+ "        header {\r\n"
            				+ "            background-color: #333;\r\n"
            				+ "            color: white;\r\n"
            				+ "            padding: 10px;\r\n"
            				+ "            display: flex;\r\n"
            				+ "            justify-content: space-between;\r\n"
            				+ "            width: 100%;\r\n"
            				+ "            position: fixed;\r\n"
            				+ "            top: 0;\r\n"
            				+ "        }\r\n"
            				+ "\r\n"
            				+ "        header img {\r\n"
            				+ "            width: 50px;\r\n"
            				+ "            height: auto;\r\n"
            				+ "        }\r\n"
            				+ "\r\n"
            				+ "        header h1 {\r\n"
            				+ "            margin: 0;\r\n"
            				+ "        }\r\n"
            				+ "\r\n"
            				+ "        .company-logo {\r\n"
            				+ "            margin-right: auto;\r\n"
            				+ "        }\r\n"
            				+ "\r\n"
            				+ "        .company-name {\r\n"
            				+ "            margin-left: auto;\r\n"
            				+ "        }\r\n"
            				+ "\r\n"
            				+ "        .center-blocks {\r\n"
            				+ "            display: flex;\r\n"
            				+ "            flex-direction: column;\r\n"
            				+ "            align-items: center;\r\n"
            				+ "            margin-top: 80px; /* Adjust as needed */\r\n"
            				+ "        }\r\n"
            				+ "\r\n"
            				+ "        .block {\r\n"
            				+ "            width: 1200px;\r\n"
            				+ "            height: 200px;\r\n"
            				+ "            margin-bottom: 20px;\r\n"
            				+ "        }\r\n"
            				+ "    </style>\r\n"
            				+ "\r\n"
            				+ "\r\n"
            				+ "</head>\r\n"
            				+ "<body>\r\n"
            				+ "<header>\r\n"
            				+ "        <div class=\"company-logo\">\r\n"
            				+ "            <img src=\"company-logo.png\" alt=\"Company Logo\">\r\n"
            				+ "        </div>\r\n"
            				+ "        <h1 class=\"company-name\">TMF_BANKING</h1>\r\n"
            				+ "    </header>\r\n"
            				+ "\r\n"
            				+ "    <div class=\"center-blocks\">\r\n"
            				+ "        <div class=\"block\">"
            				+"<h2>Welcome "+rs.getString("username")+"</h2>\r\n"
            				+ "<p>Full Name:"+rs.getString("user_fullname")+"</p>\r\n"
            				+ "<p>Phone No: "+rs.getString("phone_no")+"</p>\r\n"
            				+ "<p>Email: "+rs.getString("email")+"</p>\r\n"
            				+ "<p>Address:"+rs.getString("user_address")+"</p>"
            				+ "</div>\r\n"
            				+ " <div class=\"block\">"
            				+"<p>Account Number: "+rs.getString("bank_account_no")+"</p>"
            				+"<p>Account Number: "+rs.getString("bank_name")+"</p>"
            				+"<p>Account Number: "+rs.getString("IFSC_code")+"</p>"
            				+"<p>Account Number: "+rs.getString("account_type")+"</p>"
            				+"<p>Account Number: "+rs.getString("current_balance")+"</p>"
            				+"</div>\r\n"
            				+ " <div class=\"block\"></div>\r\n"
            				+ "</div>\r\n"
            				+ "</body>\r\n"
            				+ "</html>\r\n"
            				+ "\r\n"
            				+ "";
            		out.append(res);
            	}
            }
//           String query2 = "select *from bank_account where username=?";
//            	try (PreparedStatement preparedStatement2 = connection.prepareStatement(query2)) {
//                    preparedStatement2.setString(1, username);
//                    
//                    
//                    ResultSet rs2=preparedStatement2.executeQuery();
//                    String res="";
//                    while(rs2.next()) {
//                    	res="workin properly";
//                    	out.append(res);
//                    }
//         }
           
            	
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
	}

}
