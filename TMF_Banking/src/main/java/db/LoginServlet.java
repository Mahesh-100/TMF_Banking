package db;

import java.io.IOException;
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


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
          }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		String username = request.getParameter("username");
        String password = request.getParameter("password");
      
        BankDao dao=new BankDao();
        UserDTO user=dao.getUserDetails(username,password);

        if(user==null) {
        	//request.setAttribute("error","Invalid username or password");
        	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
        	rd.forward(request, response);
        	
        }else {
            ArrayList<BankAccountDTO> banklist=dao.getAllAccountDetails(user.getUsername());
           
     
        	HttpSession session=request.getSession();
        	session.setAttribute("user", user);
        	request.setAttribute("accounts", banklist);
        	RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
        	rd.forward(request, response);
        }
        
     
        
        
	}

}
