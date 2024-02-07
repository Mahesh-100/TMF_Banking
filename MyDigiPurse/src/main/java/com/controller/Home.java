package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.controller.dao.UserDao;
import com.controller.entity.UserDTO;
@Controller
public class Home {
	@RequestMapping("/login")
	public ModelAndView getLoginPage() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	
	
	
	@RequestMapping("/register")
    public ModelAndView register(UserDTO user) {
		UserDao userDao = new UserDao();
		
        boolean success = userDao.saveData(user);
        if (success) {
            return new ModelAndView("redirect:/login");
        } else {
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("message", "Registration failed. Please try again.");
            return modelAndView;
        }
    
}

	}

