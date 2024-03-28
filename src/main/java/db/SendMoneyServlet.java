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

/**
 * Servlet implementation class SendMoneyServlet
 */
@WebServlet("/SendMoneyServlet")
public class SendMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMoneyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			UserDTO user=(UserDTO)session.getAttribute("user");
			String username=user.getUsername();
		
			
			int sourceaccountID = Integer.parseInt(request.getParameter("accountID"));
			
			double amount=Double.parseDouble(request.getParameter("amount"));
			String toAccountNumber=request.getParameter("recipientAccount");
//			String recipientName=request.getParameter("recipientName");
			

			BankDao dao=new BankDao();
			int targetAccountID;
			
			
			try {
				
				targetAccountID = dao.getAccountID(toAccountNumber);
				TransactionDTO transactionOfSource=new TransactionDTO(sourceaccountID,targetAccountID,amount,"debit");
				TransactionDTO transactionOfTarget=new TransactionDTO(targetAccountID,sourceaccountID,amount,"credit");
				double sourceBalance = dao.getBalance(sourceaccountID);
		        double newSourceBalance = sourceBalance - amount;
		        boolean updateSourceBalance=dao.updateBalance(sourceaccountID, newSourceBalance);

		        double targetBalance = dao.getBalance(targetAccountID);
		        double newTargetBalance = targetBalance + amount;
		        boolean updateTargetBalance=dao.updateBalance(targetAccountID, newTargetBalance);
				
		        boolean sourceTransaction=dao.logTransaction(transactionOfSource);
		        boolean targetTransaction=dao.logTransaction(transactionOfTarget);
		        
		     
				if (updateSourceBalance && updateTargetBalance&&sourceTransaction&&targetTransaction) {
					ArrayList<BankAccountDTO> banklist=dao.getAllAccountDetails(username);
					request.setAttribute("accounts", banklist);
	            	RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
	            	rd.forward(request, response);
		        } else {
		            PrintWriter out=response.getWriter();
		            out.append("unable to send money");
		        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        
	        
	}

}
