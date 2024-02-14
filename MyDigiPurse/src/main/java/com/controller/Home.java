package com.controller;

import java.io.IOException;
import java.util.List;

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
	        	List<BankDTO> bank=userDAO.getBankDetailsByUserId(user.getUser_id());
	        	session.setAttribute("user", user);
	        	model.addAttribute("banklist", bank);
	           return "home"; 
	        } else {
	            return "redirect:/login"; 
	        }
	    }
	    
	   
	   
	    
//	    @GetMapping("/addaccount")
//	    public ModelAndView showBankDetailsForm() {
//	        ModelAndView modelAndView = new ModelAndView("AddAccount");
//	        modelAndView.addObject("bank", new BankDTO());
//	        return modelAndView;
//	    }
//	    
//	    @PostMapping("/addaccount")
//	    public ModelAndView addBankDetails(@ModelAttribute("bank") BankDTO bank) {
//	        ModelAndView mv = new ModelAndView();
//	        try {
//	            // Convert BankDetailsForm to BankDetails entity and save
//	        	BankDTO bankDetails = convertToBankDTOEntity(bank);
//	        	if(userDAO.saveBankDetails(bankDetails)) {
//	        		mv.setViewName("redirect:/home");
//	        		
//	        	}
//	            
//	        } catch (Exception e) {
//	            mv.setViewName("redirect:/login");
//	            mv.addObject("error", "Failed to insert bank details. Please try again.");
//	        }
//	        return mv;
//	    }
//
//	    private BankDTO convertToBankDTOEntity(BankDTO bankDetails) {
//	    	BankDTO bank_info = new BankDTO();
//	        bank_info.setUser_id(bankDetails.getUser_id());
//	        bank_info.setBank_account_no(bankDetails.getBank_account_no());
//	        bank_info.setBank_name(bankDetails.getBank_name());
//	        bank_info.setIFSC_code(bankDetails.getIFSC_code());
//	        bank_info.setAccount_type(bankDetails.getAccount_type());
//	        bank_info.setCurrent_balance(bankDetails.getCurrent_balance());
//	        return bank_info;
//	    }
	    
	    @GetMapping("/addaccount")
		public ModelAndView  getAddBankPage() {
			ModelAndView mv= new ModelAndView();
			mv.setViewName("AddAccount");
			return mv;
		}  
	    
//	    @GetMapping("/logout")
//		public ModelAndView  getLogoutPage() {
//			ModelAndView mv= new ModelAndView();
//			mv.setViewName("logout");
//			return mv;
//		}  
	   
	    
	    @PostMapping("/addaccount")
	    public String processAddAccount(HttpServletRequest request, HttpServletResponse response, Model model) {
	    	
	    	String user_id_string=request.getParameter("user_id");
	    	int user_id=Integer.parseInt(user_id_string);
	    	String bank_account=request.getParameter("accountNumber");
	    	String bank_name=request.getParameter("bankName");
	    	String IFSC_Code=request.getParameter("ifscCode");
	    	String account_type=request.getParameter("accountType");
	    	String money=request.getParameter("initialBalance");
	    	double current_balance=Double.parseDouble(money);
	    	
	    	
	    	BankDTO bank=new BankDTO(user_id,bank_account,bank_name,IFSC_Code,account_type,current_balance);
	    	if(userDAO.saveBankDetails(bank)) {
	    		
	    		
	    		return "redirect:/login";
	    	}else {
	    		model.addAttribute("error", "something went wrong");
	    		return "redirect:/addaccount";
	    	}
	    	
	    }
	    
	    
	    @PostMapping("/navigate")
	    public ModelAndView processButton(@RequestParam("selectedAction") String selectedAction,
	                               @RequestParam("selectedAccount") int accountID) {
	        ModelAndView modelAndView = new ModelAndView();
	        
	        modelAndView.addObject("accountID", accountID);
	        
	        if ("Statement".equals(selectedAction)) {
	            modelAndView.setViewName("Statement"); 
	        } else if ("AddMoney".equals(selectedAction)) {
	            modelAndView.setViewName("AddMoney"); 
	        } else if ("SendMoney".equals(selectedAction)) {
	            modelAndView.setViewName("SendMoney"); 
	        } else {
	            modelAndView.setViewName("home"); 
	        }
	        
	        return modelAndView;
	    }
	    
	    
	    @PostMapping("/addmoney")
	    public ModelAndView addMoney(@RequestParam("accountID") int accountID,
	                                   @RequestParam("amount") double amount) {
	    	ModelAndView modelAndView = new ModelAndView();
	    	double currentBalance=userDAO.getCurrentBalance(accountID);
	    	double newBalance=currentBalance+amount;
	    	boolean updateBalance=userDAO.updateBalance(accountID, newBalance);
	    	if(updateBalance) {
	    		
	    		modelAndView.setViewName("login");
	    		
	    	}else {
	    		modelAndView.setViewName("register");
	    	}
			return modelAndView;
	    	
	    	
	    }
	    
	    
	    
	    }


