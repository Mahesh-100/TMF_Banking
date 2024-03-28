package db;

import java.io.IOException;


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
    
    public ButtonServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String selectedAction = request.getParameter("selectedAction");
		
		 int accountID = Integer.parseInt(request.getParameter("selectedAccount"));
		 
		
		 request.setAttribute("accountID", accountID);
		 
		    
		    if ("Statement".equals(selectedAction)) {
		        
		    	RequestDispatcher rd=request.getRequestDispatcher("Statement.jsp");
            	rd.forward(request, response);
		    	
		    } else if ("AddMoney".equals(selectedAction)) {
		       
		    	RequestDispatcher rd=request.getRequestDispatcher("AddMoney.jsp");
            	rd.forward(request, response);
		    }else if ("SendMoney".equals(selectedAction)) {
		        
		    	RequestDispatcher rd=request.getRequestDispatcher("SendMoney.jsp");
            	rd.forward(request, response);
		    }
		    else {
		    	response.sendRedirect("home.jsp");
		    }
				
	}

}
