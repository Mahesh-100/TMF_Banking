package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	
	@GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "registration";
    }

    @PostMapping("/registration")
    public String processRegistrationForm(@ModelAttribute("user") UserDTO user, RedirectAttributes redirectAttributes) {
        UserDao userDao=new UserDao();
    	if (userDao.insertUser(user)) {
            return "redirect:/login";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to register user. Please try again.");
            return "redirect:/registration";
        }
    }
	
	

	}

