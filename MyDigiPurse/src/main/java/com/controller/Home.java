package com.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.controller.dao.UserDao;
import com.controller.entity.UserDTO;


@Controller
public class Home {
	
	UserDao userDAO= new UserDao();
	@GetMapping("/registration")
	public ModelAndView  getRegistrationPage() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("registration");
		return mv;
	}
	@PostMapping("/registration")
	public String getUserDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userFullname = request.getParameter("fullname");
        String phoneNo = request.getParameter("phone_no");
        String email = request.getParameter("email");
        String userAddress = request.getParameter("address");

    UserDTO user= new UserDTO(username,password,userFullname,phoneNo,email,userAddress);
    
       if(userDAO.saveUserDetails(user)) {
    	   return "redirect:/login";
		}else {
			return "redirect:/registration";
			}
}
	
	  @GetMapping("/login")
	    public String showLoginForm() {
	        return "login";
	    }

	    @PostMapping("/login")
	    public String processLogin(@RequestParam("username") String username,
	                               @RequestParam("password") String password,
	                               Model model) {
	    	
	        UserDTO user = userDAO.showUserDetails(username, password);
	        if (user != null) {
	            model.addAttribute("user", user);
	            return "sucess"; // Redirect to home page if user is found
	        } else {
	            return "redirect:/login"; // Redirect back to login page if user is not found
	        }
	    }
	
}

