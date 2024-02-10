package com.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.controller.dao.UserDao;
import com.controller.entity.UserDTO;
@Controller
public class Home {
	
	
	@GetMapping("/registration")
	public String  getRegistrationPage(Model model) {
		model.addAttribute("user","registartion is successful");
		return "registration";
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
    UserDao userDAO= new UserDao();
       if(userDAO.saveUserDetails(user)) {
    	return "redirect:/login";
		}else {
	   return "redirect:/registration";
   }
}
	
	@GetMapping("/login")
	public ModelAndView getLoginPage1() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("login");
		return mv;
		
	}
	
	@PostMapping("/login")
	public ModelAndView getLoginPage() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("login");
		return mv;
		
	}
}

