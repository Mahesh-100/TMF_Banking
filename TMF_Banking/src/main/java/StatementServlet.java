

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StatementServlet
 */
@WebServlet("/StatementServlet")
public class StatementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String res="\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "\r\n"
				+ "<title>TMF_Statement</title>\r\n"
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
				+ "        <a href=\"http://localhost:8082/TMF_Banking/HomeServlet\">Home</a>\r\n"
				+ "        <a href=\"http://localhost:8082/TMF_Banking/TransactionServlet\">Transaction</a>\r\n"
				+ "        <a href=\"#\">Statement</a>\r\n"
				+ "        <a href=\"http://localhost:8082/TMF_Banking/login.html\">Logout</a>\r\n"
				+ "    </nav>\r\n"
				+ "\r\n"
				+ "    <!-- Add your page content here -->\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "\r\n"
				+ "";
		out.append(res);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
