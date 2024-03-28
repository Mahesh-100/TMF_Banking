package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BankDao;
import dto.BankAccountDTO;
import dto.TransactionDTO;
import dto.UserDTO;


@WebServlet("/AddMoneyServlet")
public class AddMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddMoneyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		UserDTO user=(UserDTO)session.getAttribute("user");
		String username=user.getUsername();
		
	
		int accountID = Integer.parseInt(request.getParameter("accountID"));
		double amount=Double.parseDouble(request.getParameter("amount"));
		
		BankDao dao=new BankDao();
	
		TransactionDTO transaction=new TransactionDTO(accountID,accountID,amount,"add");
	 
		try {
			double currentBalance=dao.getBalance(accountID);
			double newBalance=currentBalance+amount;
			boolean updateSuccess= dao.updateBalance(accountID, newBalance);
			boolean TransactionSuccess=dao.logTransaction(transaction);
			if (updateSuccess &&TransactionSuccess) {
				ArrayList<BankAccountDTO> banklist=dao.getAllAccountDetails(username);
				request.setAttribute("accounts", banklist);
            	RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
            	rd.forward(request, response);
	        } else {
	            PrintWriter out=response.getWriter();
	            out.append("something went wrong");
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	

}
