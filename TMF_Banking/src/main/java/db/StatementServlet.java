package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

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

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		LocalDateTime transactionDateTime = LocalDateTime.now();
	    double amount = 89;
	    String type = "send";
	    String status = "COMPLETED"; // or any other status
	    int sourceAccountId = 2; // Replace with actual source account ID
	    int targetAccountId = 3; // Replace with actual target account ID
	    
	    
	    TransactionDTO transaction = new TransactionDTO();
	    transaction.setTxnDateTime(transactionDateTime);
	    transaction.setTxnAmount(amount);
	    transaction.setTxnType(type);
	    transaction.setTxnStatus(status);
	    transaction.setSourceAcctId(sourceAccountId);
	    transaction.setTargetAcctId(targetAccountId);
	    
	    BankDao transactionDAO = new BankDao();
	    PrintWriter out=response.getWriter();
		try {
			
			if(transactionDAO.insertTransaction(transaction)) {
				out.append("Insertion Successfull......!");
				
			}else {
				out.append("Insertion Unsuccessfull......!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	    
	    
	}

}
