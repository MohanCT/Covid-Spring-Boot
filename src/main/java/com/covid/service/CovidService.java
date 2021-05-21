package com.covid.service;

import java.util.Map;

public interface CovidService {

	public Map<String,Object> getTotalCovidCases();
	
	public Map<String,Object> getTotalCountryCovidCases();
	
	public Map<String,Object> getContinents();
	
	public Map<String,Object> getCountryList(Map<String,Object> requestData);
	
	public Map<String,Object> getDayOneTotal(Map<String,Object> requestData);
	
	public Map<String,Object> getCountryVaccine(Map<String,Object> requestData);
	
	public Map<String,Object> getGlobalVaccine();
	
	public Map<String,Object> getDistrictList();
	
	public Map<String,Object> getHospitalList(String id);
}
