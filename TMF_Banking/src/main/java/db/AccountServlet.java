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
import dto.UserDTO;


@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		UserDTO user=(UserDTO)session.getAttribute("user");
		String username=user.getUsername();
		String accountNumber=request.getParameter("accountNumber");
		String bankName=request.getParameter("bankName");
		String IFSCcode=request.getParameter("ifscCode");
		String accountType=request.getParameter("accountType");
		double currentBalance=Double.parseDouble(request.getParameter("initialBalance"));
		
				PrintWriter  out=response.getWriter();
//		out.append(username+" "+accountNumber+" "+bankName+" "+IFSCcode+" "+accountType+" "+currentBalance);
//		
		
		BankAccountDTO bankAccount= new BankAccountDTO(username,accountNumber,bankName,IFSCcode,accountType,currentBalance);
        BankDao bankDAO= new BankDao();
        try {
			if(bankDAO.insertBankAccount(bankAccount)) {
				
				response.sendRedirect("login.jsp");
				
			}else {
				out.append("Unsuccessfull");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
