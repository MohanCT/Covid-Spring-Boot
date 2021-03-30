package com.covid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppRouting {
	
	@RequestMapping(path = "/")
	public String getIndex() {
		return "index.html";
	}
	
	@RequestMapping(path = "/index")
	public String getAppIndex() {
		return "index.html";
	}

}
