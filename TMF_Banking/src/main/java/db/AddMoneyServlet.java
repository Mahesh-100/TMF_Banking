package db;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddMoneyServlet")
public class AddMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddMoneyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String selectedAccountNumber=request.getParameter("accountNumber");
		double amountToAdd=Double.parseDouble(request.getParameter("amount"));
		
		PrintWriter out=response.getWriter();
		out.append(selectedAccountNumber+" "+amountToAdd);
		
	}

}
