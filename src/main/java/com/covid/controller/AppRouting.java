package com.covid.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppRouting {
	
//	@GetMapping(path = "/")
//	public String getIndex() {
//		return "index.html";
//	}
	
	
	
	@GetMapping(path = "")
	public String getIndex(Model model) {
		model.addAttribute("pageTitle", "COVID Tracker 19 | Live Coronavirus Updates");
		model.addAttribute("pageCano", "https://www.covidtracker19.com");
		model.addAttribute("pageDesc", "Find live COVID status updates in world with up to date cases, vaccination counts and maps with COVID Tracker 19.");
		model.addAttribute("pageKey", "covid tracker, corona tracker, covid-19, covid near me, covid 19 map, covid update, covid death rate, covid deaths, covid 19 update, coronavirus case, covid case, covid count,covid vaccination count");
        return "index.html";
	}
	
//	@GetMapping(path = "/index")
//	public String getAppIndex(Model model) {
//		model.addAttribute("pageTitle", "COVID Tracker 19 | Live Coronavirus Updates");
//		model.addAttribute("pageCano", "https://www.covidtracker19.com/index");
//		model.addAttribute("pageDesc", "Find live COVID status updates in world with up to date cases, vaccination counts and maps with COVID Tracker 19.");
//		model.addAttribute("pageKey", "covid tracker, corona tracker, covid-19, covid near me, covid 19 map, covid update, covid death rate, covid deaths, covid 19 update, coronavirus case, covid case, covid count,covid vaccination count");
//		return "index.html";
//	}
	
	@GetMapping(path = "/country/{id}")
	public String getAppCountry(@PathVariable("id") String countryName,Model model) {
		model.addAttribute("pageTitle", "COVID Tracker 19 | Live updates in "+countryName);
		model.addAttribute("pageCano", "https://www.covidtracker19.com/country/"+countryName);
		List<String> noCountryMap = Arrays.asList("Brazil","Chile","Denmark","Netherlands");
		 if(noCountryMap.contains(countryName)){
			 model.addAttribute("pageDesc", "Find live COVID status updates in "+countryName+" with up to date cases and vaccination counts with COVID Tracker 19.");
         } else {
        	 model.addAttribute("pageDesc", "Find live COVID status updates in "+countryName+" with up to date cases, vaccination counts and maps with COVID Tracker 19.");
         }
		model.addAttribute("pageKey", "covid "+countryName+" case, "+countryName+" covid map, today "+countryName+" covid, covid count "+countryName+", covid death in "+countryName+", "+countryName+" corona tracker, corona in "+countryName+", "+countryName+" covid update, "+countryName+" vaccination count, coronavirus in "+countryName+", "+countryName+" covid tracker");
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
