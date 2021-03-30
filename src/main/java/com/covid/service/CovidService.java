package com.covid.service;

import java.util.Map;

public interface CovidService {

	public Map<String,Object> getTotalCovidCases();
	
	public Map<String,Object> getTotalCountryCovidCases();
}
