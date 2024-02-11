package com.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.controller.dao.UserDao;
import com.controller.entity.BankDTO;
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
	                               HttpSession session,
	                               Model model) {
	    	
	        UserDTO user = userDAO.showUserDetails(username, password);
	        if (user != null) {
	        	session.setAttribute("username", user.getUsername());
	           return "home"; 
	        } else {
	            return "redirect:/login"; 
	        }
	    }
	    
	    @GetMapping("/addaccount")
	    public String showBankForm() {
	        return "AddAccount";
	    }  	  
	    
	    @PostMapping("/addaccount")
	    public String processAddAccount(HttpServletRequest request, HttpServletResponse response, Model model) {
	    	
	    	int user_id=Integer.parseInt(request.getParameter("use_id"));
	    	String bank_account=request.getParameter("accountNumber");
	    	String bank_name=request.getParameter("bankName");
	    	String IFSC_Code=request.getParameter("ifscCode");
	    	String account_type=request.getParameter("accountType");
	    	double current_balance=Double.parseDouble("initialBalance");
	    	
	    	BankDTO bank=new BankDTO(user_id,bank_account,bank_name,IFSC_Code,account_type,current_balance);
	    	if(userDAO.saveBankDetails(bank)) {
	    		model.addAttribute("bank", bank);
	    		return "redirect:/home";
	    	}else {
	    		model.addAttribute("error", "something went wrong");
	    		return "redirect:/AddAccount";
	    	}
	    	
	    }
}

