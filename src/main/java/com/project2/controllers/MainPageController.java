package com.project2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {
	@RequestMapping(value="/index")
	public String showCarmanagerPage() {
			return "redirect:/viewcars";
		}
	
}
