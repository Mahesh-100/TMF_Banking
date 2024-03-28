package db;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.TransactionDTO;

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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			int accountID = Integer.parseInt(request.getParameter("accountID"));
		   String startDateStr = request.getParameter("startDate");
	       String endDateStr = request.getParameter("endDate");

	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date startDate = null;
	        Date endDate = null;
	        
	        try {
	            startDate = sdf.parse(startDateStr);
	            endDate = sdf.parse(endDateStr);
	            BankDao transactionDAO = new BankDao();
	            List<TransactionDTO> transactions = transactionDAO.getAllTransactions(accountID,startDate, endDate);
	            request.setAttribute("transactions", transactions);
	            RequestDispatcher dispatcher = request.getRequestDispatcher("displayStatement.jsp");
	            dispatcher.forward(request, response);
	        } catch (ParseException e) {
	            e.printStackTrace();
	            
	        }
	    
	    
	    
		

	    
	    
	}

}
