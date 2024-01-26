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
		
		
			String fromAccountNumber=request.getParameter("fromAccountNumber");
			String toAccountNumber=request.getParameter("recipientAccount");
//			String recipientName=request.getParameter("recipientName");
			double amount = Double.parseDouble(request.getParameter("amount"));
			
			request.setAttribute("amount", amount);
			request.setAttribute("send", "sent");
			BankDao dao=new BankDao();
			
			boolean sendMoneySuccess;
			try {
				sendMoneySuccess = dao.sendMoney(fromAccountNumber, toAccountNumber, amount);
				if (sendMoneySuccess) {
					ArrayList<BankAccountDTO> banklist=dao.getAllAccountDetails(username);
					request.setAttribute("accounts", banklist);
	            	RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
	            	rd.forward(request, response);
		        } else {
		            PrintWriter out=response.getWriter();
		            out.append("unable to send money");
		        }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        // Redirect back to the home page or another appropriate page based on the send money result
	        
	}

}
