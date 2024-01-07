

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;


@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TransactionServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		//HttpSession session =request.getSession();
       	//String user=(String) session.getAttribute("user");
		
		String	user="";
		Cookie[] cookie=request.getCookies();
		for( Cookie c:cookie) {
			if(c.getName().equals("user")) {
				user=c.getValue();
			}
			
		}
		String DB_URL = "jdbc:mysql://localhost:3306/bank_customers";
        String DB_USER = "root";
        String DB_PASSWORD = "89788";
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        	Statement stmt=conn.createStatement();
        	ResultSet rs=stmt.executeQuery("select *from user_info where user='"+user+"'");
        	String res="";
        	if(rs.next()==false) {
       		 res="<html >\r\n"
       				+ "<body>\r\n"
       				+ "<h2>Unable to fetch query</h2>\r\n"
       				+ "</body>\r\n"
       				+ "</html>";
       		 out.append(res);
        	}else {
        		res="\r\n"
        				+ "<html>\r\n"
        				+ "<head>\r\n"
        				+ "\r\n"
        				+ "<title>TMF_Transaction</title>\r\n"
        				+ "<style>\r\n"
        				+ "        body {\r\n"
        				+ "            margin: 0;\r\n"
        				+ "            font-family: Arial, sans-serif;\r\n"
        				+ "        }\r\n"
        				+ "\r\n"
        				+ "        header {\r\n"
        				+ "            background-color: #333;\r\n"
        				+ "            color: white;\r\n"
        				+ "            padding: 10px;\r\n"
        				+ "            display: flex;\r\n"
        				+ "            justify-content: space-between;\r\n"
        				+ "            align-items: center;\r\n"
        				+ "        }\r\n"
        				+ "\r\n"
        				+ "        header img {\r\n"
        				+ "            width: 50px; /* Adjust the size of the logo as needed */\r\n"
        				+ "            height: auto;\r\n"
        				+ "        }\r\n"
        				+ "\r\n"
        				+ "        nav {\r\n"
        				+ "            background-color: #f4f4f4;\r\n"
        				+ "            padding: 10px;\r\n"
        				+ "        }\r\n"
        				+ "\r\n"
        				+ "        nav a {\r\n"
        				+ "            text-decoration: none;\r\n"
        				+ "            color: #333;\r\n"
        				+ "            padding: 8px 16px;\r\n"
        				+ "            margin: 0 8px;\r\n"
        				+ "            border-radius: 4px;\r\n"
        				+ "            transition: background-color 0.3s;\r\n"
        				+ "        }\r\n"
        				+ "\r\n"
        				+ "        nav a:hover {\r\n"
        				+ "            background-color: #ddd;\r\n"
        				+ "        }\r\n"
        				+ "    </style>\r\n"
        				+ "</head>\r\n"
        				+ "<body>\r\n"
        				+ "<header>\r\n"
        				+ "        <div>\r\n"
        				+ "            <img src=\"your-logo.png\" alt=\"Company Logo\">\r\n"
        				+ "        </div>\r\n"
        				+ "        <div>\r\n"
        				+ "            <h1>TMF_Banking</h1>\r\n"
        				+ "        </div>\r\n"
        				+ "    </header>\r\n"
        				+ "\r\n"
        				+ "    <nav>\r\n"
        				+ "       <a href=\"http://localhost:8082/TMF_Banking/HomeServlet\">Home</a>\r\n"
        				+ "        <a href=\"#\">Transaction</a>\r\n"
        				+ "        <a href=\"http://localhost:8082/TMF_Banking/StatementServlet\">Statement</a>\r\n"
        				+ "        <a href=\"http://localhost:8082/TMF_Banking/login.html\">Logout</a>\r\n"
        				+ "    </nav>\r\n"
        				+ "\r\n"
        				+ "   <h1>Welcome  "+user+"</h1>\r\n"
        				+ "\r\n"
        				+ "</body>\r\n"
        				+ "</html>\r\n"
        				+ "\r\n"
        				+ "";
        	}
        		out.append(res);
        		
		}catch(SQLException | ClassNotFoundException e){
            	e.printStackTrace();
            	
            }
        		
        	

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
