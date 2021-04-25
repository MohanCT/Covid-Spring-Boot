package com.covid.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@GetMapping(value="/getContinents")
	public ResponseEntity<Map<String,Object>> getContinents(){
		Map<String,Object> responseMap = covidService.getContinents();
		return new ResponseEntity<>(responseMap,HttpStatus.OK);
	}
	
	@PostMapping(value="/getCountryList")
	public ResponseEntity<Map<String,Object>> getCountryList(@RequestBody Map<String,Object> requestData){
		Map<String,Object> responseMap = covidService.getCountryList(requestData);
		return new ResponseEntity<>(responseMap,HttpStatus.OK);
	}
	
	@PostMapping(value="/getDayOneTotal")
	public ResponseEntity<Map<String,Object>> getDayOneTotal(@RequestBody Map<String,Object> requestData){
		Map<String,Object> responseMap = covidService.getDayOneTotal(requestData);
		return new ResponseEntity<>(responseMap,HttpStatus.OK);
	}
	
	@PostMapping(value="/getCountryVaccine")
	public ResponseEntity<Map<String,Object>> getCountryVaccine(@RequestBody Map<String,Object> requestData){
		Map<String,Object> responseMap = covidService.getCountryVaccine(requestData);
		return new ResponseEntity<>(responseMap,HttpStatus.OK);
	}
	
	
//	@GetMapping(value="/getTotalCovidCases1")
//	public ResponseEntity<Map<String,Object>> getTotalCovidCases(){
//		Map<String,Object> responseMap = covidService.getTotalCovidCases();
//		return new ResponseEntity<>(responseMap,HttpStatus.OK);
//	}
}
