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
      
          

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String username = request.getParameter("username");
        String password = request.getParameter("password");
                 
        BankDao dao=new BankDao();
        UserDTO user=dao.getUserDetails(username);
        HttpSession session=request.getSession();
        session.setAttribute("user", user);
    	

        if(user!=null) {
        	if(user.getPassword().equals(password)) {
        		ArrayList<BankAccountDTO> banklist=dao.getAllAccountDetails(user.getUsername());
                
        	     
        		
        	   
            	request.setAttribute("accounts", banklist);
            	RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
            	rd.forward(request, response);
        	}else {
        		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
            	rd.forward(request, response);
        	}
        	//request.setAttribute("error","Invalid username or password");
        	
        	
        }else {
        	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
        	rd.forward(request, response);
            
        }
        
     
        
        
	}

}
