package db;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ButtonServlet
 */
@WebServlet("/ButtonServlet")
public class ButtonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ButtonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String selectedAction = request.getParameter("selectedAction");
		 String accountNumber=request.getParameter("selectedAccount");
		 request.setAttribute("accountNumber", accountNumber);
		 
//		 PrintWriter out=response.getWriter();
//		 out.append(accountNumber);
		    
		    if ("AddMoney".equals(selectedAction)) {
		        // Handle Add Money action
		    	
		    	RequestDispatcher rd=request.getRequestDispatcher("AddMoney.jsp");
            	rd.forward(request, response);
		    } else if ("Statement".equals(selectedAction)) {
		        // Handle Request Statement action
		    	RequestDispatcher rd=request.getRequestDispatcher("Statement.jsp");
            	rd.forward(request, response);
		    }else if ("SendMoney".equals(selectedAction)) {
		        // Handle Request Statement action
		    	RequestDispatcher rd=request.getRequestDispatcher("SendMoney.jsp");
            	rd.forward(request, response);
		    }
		    else {
		    	PrintWriter out=response.getWriter();
		    	out.append("unable to navigate");
		    }
				
	}

}
