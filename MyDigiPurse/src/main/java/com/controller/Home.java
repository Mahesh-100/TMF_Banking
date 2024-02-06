package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Home {
	@RequestMapping("/login")
	public ModelAndView getLoginPage() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping("/register")
	public ModelAndView getRegisterPage() {
		ModelAndView mv= new ModelAndView();
		mv.setViewName("registration");
		return mv;
	}
}
