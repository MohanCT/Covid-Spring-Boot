package com.covid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppRouting {
	
	@GetMapping(path = "/")
	public String getIndex() {
		return "index.html";
	}
	
	@GetMapping(path = "/index")
	public String getAppIndex() {
		return "index.html";
	}
	
	@GetMapping(path = "/country/{id}")
	public String getAppCountry() {
		return "index.html";
	}
	
	@GetMapping(path = "/sitemap.xml" ,produces = "application/xml" )
	public String getSiteMap() {
		return "sitemap.xml";
	}
	
	@GetMapping(path = "/robots.txt" ,produces = "application/text")
	public String getRobots() {
		return "robots.txt";
	}

}
