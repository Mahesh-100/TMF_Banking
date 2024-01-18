

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BankDao;
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
        UserDTO user=dao.getUserDetails(username, password);
        if(user!=null) {
        	HttpSession session=request.getSession();
        	session.setAttribute("user", user);
        	RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
        	rd.forward(request, response);
        }else {
        	response.sendRedirect("login.html");
        }
        
     
        
        
	}

}
