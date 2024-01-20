package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BankDao;
import dto.BankAccountDTO;


@WebServlet("/AddAccount")
public class AddAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddAccountServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();	
		String username=(String)session.getAttribute("user");
		String accountNumber=request.getParameter("accountNumber");
		String bankName=request.getParameter("bankName");
		String IFSCcode=request.getParameter("ifscCode");
		String accountType=request.getParameter("accountType");
		String currentBalnce=request.getParameter("initialBalance");
		PrintWriter out=response.getWriter();
		BankAccountDTO bankAccount=new BankAccountDTO(username,accountNumber,bankName,IFSCcode,accountType,currentBalnce);
		BankDao dao= new BankDao();
		try {
			boolean success=dao.insertBankAccount(bankAccount);
			if(success) {
				out.print("successfully inserted");
			}else {
				out.print("unsuccess");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
