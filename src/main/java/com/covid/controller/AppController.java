package com.covid.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.covid.service.CovidService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value="/covidApi")
public class AppController {
	
	@Autowired
	CovidService covidService; 

	@GetMapping(value="/getTotalCovidCases")
	public ResponseEntity<Map<String,Object>> getTotalCovidCases(){
		Map<String,Object> responseMap = covidService.getTotalCovidCases();
		return new ResponseEntity<>(responseMap,HttpStatus.OK);
	}
	
	@GetMapping(value="/getTotalCountryCovidCases")
	public ResponseEntity<Map<String,Object>> getTotalCountryCovidCases(){
		Map<String,Object> responseMap = covidService.getTotalCountryCovidCases();
		return new ResponseEntity<>(responseMap,HttpStatus.OK);
	}
	
	
//	@GetMapping(value="/getTotalCovidCases1")
//	public ResponseEntity<Map<String,Object>> getTotalCovidCases(){
//		Map<String,Object> responseMap = covidService.getTotalCovidCases();
//		return new ResponseEntity<>(responseMap,HttpStatus.OK);
//	}
}
